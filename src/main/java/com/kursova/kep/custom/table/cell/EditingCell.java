package com.kursova.kep.custom.table.cell;

import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * Created by Mr. Skip.
 */

public class EditingCell<S, T> extends TableCell<S, T> {
    private final Class aClass;
    private TextField textField;

    public EditingCell(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(getString());
        setGraphic(null);
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
            } else {
                setText(getString());
                setGraphic(null);
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
        textField.focusedProperty().addListener((arg0, arg1, arg2) -> {
            if (!arg2) {
                String s = textField.getText();
                if (s == null || (s.isEmpty() && (aClass == Long.class || aClass == Double.class)))
                    commitEdit(null);
                else if (aClass == Long.class)
                    commitEdit((T) (Long) Long.parseLong(s));
                else if (aClass == Double.class)
                    commitEdit((T) (Double) Double.parseDouble(s));
                else
                    commitEdit((T) textField.getText());
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
                        || e.getCharacter().matches("[їЇіІєЄ]")) {
                } else {
                    e.consume();
                }
            }
            else if (aClass == Long.class){
                if (e.getCharacter().matches("[0-9]")) {
                } else {
                    e.consume();
                }
            }
            else if (aClass == Double.class){
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
