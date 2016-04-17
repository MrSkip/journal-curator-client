package com.kursova.kep.custom.table;

import com.kursova.kep.custom.table.cell.EditCellWithForeignKey;
import com.kursova.kep.custom.table.cell.EditCellWithDatePick;
import com.kursova.kep.custom.table.cell.EditCellBasic;
import com.kursova.kep.entity.BaseEntity;
import com.kursova.kep.entity.Group;
import com.kursova.kep.rest.Client;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mr. Skip.
 */

public class TableColumnsGenerator {
    private HashMap<String, String> columnsName = new HashMap<>();
    private static TableView table = null;

    public static TableColumnsGenerator setTableView(TableView table){
        TableColumnsGenerator.table = table;
        return new TableColumnsGenerator();
    }

    public TableColumnsGenerator setColumnsName(HashMap<String, String> columnsName) {
        this.columnsName = columnsName;
        return new TableColumnsGenerator();
    }

    public <S extends BaseEntity> void generateColumns(List<S> list, Class<S> sClass){
        ObservableList<S> observableList = FXCollections.observableArrayList(list);
        table.setItems(observableList);

        table.setTableMenuButtonVisible(true);
        table.setEditable(true);

        Method[] methods = sClass.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && !"getClass".equals(method.getName())){
                table.getColumns().add(0, byType(method));
            }
        }
    }

    private <S extends BaseEntity, T> TableColumn<S, T> byType(Method method){
        TableColumn<S, T> column = new TableColumn<>(customColumn(method.getName()));

        // Add editable a columns with foreign key (ManyToOne)
        if (method.getReturnType().getSuperclass() == BaseEntity.class) {
            return generateReferColumn(method, column);
        }

        // Add editable a columns with foreign key (ManyToMany)
        if (method.getReturnType() == List.class || method.getReturnType().getSuperclass() == BaseEntity.class) {
            return column;
        }

        column.setCellValueFactory(new PropertyValueFactory<>(method.getName().substring(3)));

        // A column with primary key don`t need to edit
        if (method.getName().equals("getId")) return column;

        // Make editable a column
        if (method.getReturnType() == Date.class)
            column.setCellFactory(param -> new EditCellWithDatePick<>());
        else
            column.setCellFactory(param -> new EditCellBasic<>(method.getReturnType()));

        column.setOnEditCommit(event -> {
            try {
                BaseEntity baseEntity = event.getTableView().getItems().get(event.getTablePosition().getRow());
                Method method1 = baseEntity.getClass().getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType());
                method1.invoke(baseEntity, (T)event.getNewValue());

                Client.post(method.getDeclaringClass().getSimpleName().toLowerCase(),
                        event.getTableView().getItems().get(event.getTablePosition().getRow()).getClass())
                        .setRequest(event.getTableView().getItems().get(event.getTablePosition().getRow()))
                        .build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return column;
    }

    private <S extends BaseEntity, T> TableColumn<S, T> generateReferColumn(Method method, TableColumn<S, T> column) {
        column.setCellValueFactory(param -> {
            try {
                Method method1 = param.getValue().getClass().getMethod(method.getName());
                Long aLong = ((S) method1.invoke(param.getValue())).getId();
                return new SimpleObjectProperty<>((T) aLong);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        });

        column.setCellFactory(param -> new EditCellWithForeignKey<>(method.getReturnType(), method.getDeclaringClass()));

        column.setOnEditCommit(event -> {
            try {
                Object group = Client.get(method.getReturnType().getSimpleName().toLowerCase()+"/" + event.getNewValue(), method.getReturnType())
                        .build();

                Method method2 = method.getDeclaringClass().getMethod("set" + method.getReturnType().getSimpleName(), Group.class);
                method2.invoke(event.getRowValue(), group);

                Client.post(method.getDeclaringClass().getSimpleName().toLowerCase(), method.getDeclaringClass())
                        .setRequest(event.getRowValue())
                        .build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return column;
    }

    private String customColumn(String methodName){
        final String[] name = {methodName.substring(3)};
        columnsName.forEach((s, s2) -> {
            if (methodName.equalsIgnoreCase("get" + s)) {
                name[0] = s2;
            }
        });
        return name[0];
    }

}
