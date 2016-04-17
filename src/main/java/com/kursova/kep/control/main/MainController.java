package com.kursova.kep.control.main;

import com.kursova.kep.custom.table.TableColumnsGenerator;
import com.kursova.kep.entity.Department;
import com.kursova.kep.entity.Group;
import com.kursova.kep.entity.Student;
import com.kursova.kep.rest.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.lang.reflect.Array;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Mr. Skip.
 */

public class MainController implements Initializable{
    public TableView<Object> table;

    public Button
            butDepartment,
            butGroup,
            butStudent,
            butVisiting,
            butProgress;
    public Label labCurrentTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            List<Student> list = Client.get("student", Student[].class).build();
            TableColumnsGenerator.setTableView(table).generateColumns(list, Student.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        list.add(new Department((long)1, date, "new"));
//
//        TableColumnsGenerator.setTableView(table).generateColumns(list, Department.class);
    }

}
