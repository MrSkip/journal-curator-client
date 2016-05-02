package com.kursova.kep.custom;

import com.kursova.kep.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mr. Skip.
 */
public class TaskLabelFactory {

    private static List<ValuesForTaskLabels> list = Arrays.asList(
            new ValuesForTaskLabels("Отримати усіх кураторів для відділення",
                    "department/curator", "Введіть відділення", String[].class, "name"),
            new ValuesForTaskLabels("Отримати групу за введеною назвою",
                    "group/name", "Введіть назву групи", Group.class, "groupName"),
            new ValuesForTaskLabels("Отримати успішність для групи",
                    "progress/", "Введіть назву групи", Progress[].class, "groupName"),
            new ValuesForTaskLabels("Отримати студентів з негативними оцінками",
                    "department/curator", "Введіть предмет", Student[].class, "subjectName"),
            new ValuesForTaskLabels("Отримати студентів на раду профілактику",
                    "student/prevention", "Введіть назву групи", Student[].class, "groupName"),
            new ValuesForTaskLabels("Отримати студентві підлітків",
                    "student/teenager-in-department", "Введіть назву відділення", Student[].class, "departmentName"),
            new ValuesForTaskLabels("Отримати студентів з пільгами по відділенню",
                    "student/benefit-in-department", "Введіть назву відділення", Student[].class, "departmentName"),
            new ValuesForTaskLabels("Отримати студентів з пільгами по групі",
                    "student/benefit-in-group", "Введіть назву групи", Student[].class, "groupName"),
            new ValuesForTaskLabels("Отримати студентів з доганами",
                    "student/reprimand", null, Student[].class),
            new ValuesForTaskLabels("Отримати студентів для групи",
                    "student/group", "Введіть назву групи", Student[].class, "groupName"),
            new ValuesForTaskLabels("Отримати розширену інформацію про студента",
                    "student/extend", "Введіть ім’я студента", StudentExtend[].class, "studentName"),
            new ValuesForTaskLabels("Отримати студента",
                    "student", "Введіть ім’я студента", Student[].class, "name"),
            new ValuesForTaskLabels("Отримати предмети для групи",
                    "subject/group", "Введіть назву групи", Subject[].class, "groupName"),
            new ValuesForTaskLabels("Отримати відвідуваність за тиждень",
                    "visiting/week", "Введіть назву групи", Visiting[].class, "groupName"),
            new ValuesForTaskLabels("Отримати відвідуваність за місяць",
                    "department/month", "Введіть назву групи", Visiting[].class, "groupName")
    );

    public static List<String> getLabelNames(){
        return list.stream().map(ValuesForTaskLabels::getName).collect(Collectors.toList());
    }

    public static List<ValuesForTaskLabels> getAllValues(){
        return list;
    }

    public static ValuesForTaskLabels getValueForLabel(String labelName){
        for (ValuesForTaskLabels valuesForTaskLabels : list) {
            if (valuesForTaskLabels.getName().equals(labelName))
                return valuesForTaskLabels;
        }
        return null;
    }



}
