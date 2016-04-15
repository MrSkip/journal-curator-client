package com.kursova.kep.custom.table;

import com.kursova.kep.custom.table.cell.DatePickerCell;
import com.kursova.kep.custom.table.cell.EditingCell;
import com.kursova.kep.entity.BaseEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

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

    public <S extends BaseEntity> TableView<S> generateColumns(List<S> list, Class<S> sClass){
        return new TableColumnsGenerator().setValue(list, sClass);
    }

    private <S extends BaseEntity> TableView<S> setValue(List<S> list, Class<S> sClass){
        ObservableList<S> observableList = FXCollections.observableArrayList(list);
        table.setItems(observableList);

        table.setTableMenuButtonVisible(true);
        table.setEditable(true);

        Method[] methods = sClass.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && !"getClass".equals(method.getName())){
                table.getColumns().add(byType(method, sClass));
            }
        }
        return table;
    }

    private <S extends BaseEntity, T> TableColumn<S, T> byType(Method method, Class<S> sClass){
        TableColumn<S, T> column = new TableColumn<>(customColumn(method.getName()));
        column.setCellValueFactory(new PropertyValueFactory<>(method.getName().substring(3)));

        if (method.getReturnType() == Date.class)
            column.setCellFactory(param -> new DatePickerCell<>());
        else
            column.setCellFactory(param -> new EditingCell<>(method.getReturnType()));

        column.setOnEditCommit(event -> {
            try {
                BaseEntity baseEntity = event.getTableView().getItems().get(event.getTablePosition().getRow());
                Method method1 = baseEntity.getClass().getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType());
                method1.invoke(baseEntity, event.getNewValue());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        return column;
    }

    private <S extends BaseEntity, T> void generateLongColumn(TableColumn<S, T> column){
        column.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<T>() {
            @Override
            public String toString(T object) {
                return object == null
                        ? null
                        : object.toString();
            }

            @Override
            public T fromString(String string) {
                return string == null || string.isEmpty()
                        ? null
                        : (T) (Long) Long.parseLong(string);
            }
        }));
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
