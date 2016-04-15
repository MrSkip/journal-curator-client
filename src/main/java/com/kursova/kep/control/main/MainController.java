package com.kursova.kep.control.main;

import com.kursova.kep.custom.table.TableColumnsGenerator;
import com.kursova.kep.entity.Department;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Department> list = new ArrayList<>();
        Date date = new Date(Calendar.getInstance().getTime().getTime());
        System.out.println(date);
        list.add(new Department((long)1, date, "new"));

        TableColumnsGenerator.setTableView(table).generateColumns(list, Department.class);
    }

}
