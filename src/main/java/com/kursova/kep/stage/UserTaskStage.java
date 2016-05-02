package com.kursova.kep.stage;

import com.kursova.kep.custom.TaskLabelFactory;
import com.kursova.kep.custom.ValuesForTaskLabels;
import com.kursova.kep.custom.table.TableColumnsGenerator;
import com.kursova.kep.message.MessageBox;
import com.kursova.kep.rest.Client;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mr. Skip.
 */
public class UserTaskStage extends Stage{
    private static UserTaskStage userTaskStage;

    public static UserTaskStage getUserTaskStage(Label label, TableView table){
        return userTaskStage == null
                ? new UserTaskStage(label, table)
                : userTaskStage;
    }

    private final VBox vBox;
    private final Label label;
    private final TableView table;

    private UserTaskStage(Label label, TableView table){
        this.label = label;
        this.table = table;

        vBox = new VBox();

        initVbox();
        initStage();
        initScene();
    }

    private void initVbox() {
        vBox.setSpacing(8);
        vBox.autosize();
    }

    private void initStage() {
        setHeight(300);
        setWidth(445);
    }

    private void initScene() {
        String path  = null;
        try {
            path = getClass().getClassLoader().getResource("view/main/style.css").toURI().toURL().toExternalForm();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }

        ScrollPane scrollPane = new ScrollPane(vBox);

        scrollPane.getStylesheets().clear();
        scrollPane.getStylesheets().add(path);

        System.out.println(scrollPane.getStyle());
        setScene(new Scene(scrollPane));
        for (ValuesForTaskLabels valuesForTaskLabels : TaskLabelFactory.getAllValues()) {
            Label label = createLabel(valuesForTaskLabels);
            label.setOnMouseClicked(event -> setEventToLabels(event, valuesForTaskLabels));
        }
    }

    private Label createLabel(ValuesForTaskLabels valuesForTaskLabels) {
        Label label = new Label(valuesForTaskLabels.getName());
        label.setPrefWidth(417);
        label.setId("top-label");
        label.setCursor(Cursor.HAND);
        vBox.getChildren().add(label);
        VBox.setMargin(label, new Insets(1, 2, 0, 2));
        return label;
    }

    private void setEventToLabels(MouseEvent event, ValuesForTaskLabels value){
        if (event.getButton() != MouseButton.PRIMARY)
            return;
        label.setText("Завдання");

        String typedString = MessageBox.setTitleForBox(value.getTitle())
                .setFormat(value.getFormat())
                .run();

        if (typedString == null || typedString.isEmpty()) {
            close();
            return;
        }

        List list = Client.get(value.getUri(), value.getReturnedClass())
                .setVariable(new HashMap<String, String>(){
                    {
                        put(value.getParam(), typedString);
                    }
                })
                .build();

        if (list == null || list.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Інформаційне вікно");
            alert.setHeaderText(null);
            alert.setContentText("Для вибраного пункту немає жодного запису");
            alert.showAndWait();
            close();
            return;
        }

        try {
            TableColumnsGenerator.setTableView(table)
                    .generateColumns(list, Class.forName(value.getReturnedClass().getTypeName().replace("[]", "")));
            close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
