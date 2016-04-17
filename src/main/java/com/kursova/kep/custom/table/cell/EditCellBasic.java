package com.kursova.kep.custom.table.cell;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * Created by Mr. Skip.
 */

public class EditCellBasic<S, T> extends TableCell<S, T> {
    private final Class aClass;
    private TextField textField;

    public EditCellBasic(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();

            createTextField();
            setText(null);

            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(getString());
        setContentDisplay(ContentDisplay.TEXT_ONLY);
    }

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            } else {
                setText(getString());
                setContentDisplay(ContentDisplay.TEXT_ONLY);
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
        textField.focusedProperty().addListener((arg0, arg1, arg2) -> {
            if (!arg2) {
                String s = textField.getText();
                if (s == null || (s.isEmpty()
                        && (aClass == Long.class
                        || aClass == Double.class
                        || aClass == long.class
                        || aClass == double.class
                        || aClass == int.class
                        || aClass == Integer.class)))
                    commitEdit(null);
                else if (aClass == Long.class)
                    commitEdit((T) (Long) Long.parseLong(s));
                else if (aClass == Double.class)
                    commitEdit((T) (Double) Double.parseDouble(s));
                else if (aClass == Integer.class)
                    commitEdit((T) (Integer) Integer.parseInt(s));
                else //(T) textField.getText(){
                {
                    commitEdit((T) textField.getText());
                }
            }
        });
        textField.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            TextField txt_TextField = (TextField) e.getSource();
            if (txt_TextField.getText().length() >= 100) {
                e.consume();
            }
            if (aClass == String.class) {
                if (e.getCharacter().matches("[A-Za-z]")
                        || e.getCharacter().matches("[А-Яа-я]")
                        || e.getCharacter().matches("[їЇіІєЄ@. ]")) {
                } else {
                    e.consume();
                }
            }
            else if (aClass == long.class
                    || aClass == int.class
                    || aClass == Integer.class
                    || aClass == Long.class){
                if (e.getCharacter().matches("[0-9]")) {
                } else {
                    e.consume();
                }
            }
            else if (aClass == double.class || aClass == Double.class){
                if (e.getCharacter().matches("[0-9]") || e.getCharacter().matches("[.]")) {
                } else {
                    e.consume();
                }
            }
        });

    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}
