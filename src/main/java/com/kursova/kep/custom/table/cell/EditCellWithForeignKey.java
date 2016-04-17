package com.kursova.kep.custom.table.cell;

import com.kursova.kep.control.main.edit.ControlForeignStage;
import com.kursova.kep.custom.stage.ExtendStage;
import com.kursova.kep.entity.*;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 * Created by Mr. Skip.
 */

// For foreign key manyToOne
public class EditCellWithForeignKey<S extends BaseEntity, T> extends TableCell<S, T> {
    private Class childrenClass = null;
    private Class parentClass = null;

    private ExtendStage stage;

    public EditCellWithForeignKey(Class childrenClass, Class parentClass){
        this.childrenClass = childrenClass;
        this.parentClass = parentClass;
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
            if (isEditing()) {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }

    public void createStage(){
        stage = new ExtendStage(EditCellWithForeignKey.class.getClassLoader()
                .getResource("view/main/cellfirst/view.fxml"));

        stage.initStyle(StageStyle.UTILITY);

        stage.onCloseRequestProperty().setValue(event -> {
            cancelEdit();
        });

        ControlForeignStage editFirst = stage.getController();

        editFirst.setClass(childrenClass);

        editFirst.add.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.PRIMARY && !editFirst.table.getItems().isEmpty()){

                if (editFirst.table.getSelectionModel().getSelectedItem() == null) {
                    stage.close();
                    cancelEdit();
                }
                else {
                    Long aLong = ((BaseEntity) editFirst.table.getSelectionModel().getSelectedItem()).getId();
                    commitEdit((T) aLong);
                    stage.close();
                }
            }
        });

        stage.onShownProperty().setValue(event -> editFirst.setId(getString()));

        editFirst.close.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.PRIMARY){
                stage.close();
            }
        });
    }

    public void startEdit() {
        if (!isEmpty()){
            super.startEdit();
            if (stage == null){
                createStage();
            }
            stage.showAndWait();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getString());
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void commitEdit(T newValue) {
        super.commitEdit(newValue);
    }

    private String getString() {
        return getItem() == null ? null : getItem().toString();
    }

}