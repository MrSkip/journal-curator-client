package com.kursova.kep.custom;

import com.kursova.kep.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mr. Skip.
 */

public class CustomProperties {

    public static Class getClassFromHeaderButtons(String buttonName){
        Class aClass = null;
        switch (buttonName){
            case "Відділення":
                aClass = Department.class;
                break;
            case "Групи":
                aClass = Group.class;
                break;
            case "Студенти":
                aClass = Student.class;
                break;
            case "Предмети":
                aClass = Subject.class;
                break;
            case "Відвідування":
                aClass = Visiting.class;
                break;
            case "Успішність":
                aClass = Progress.class;
                break;
        }
        return aClass;
    }

    public static List<VariablesForCell> getCellFormat(String originTableName){
        switch (originTableName){
            case "Group":
                return cellFormatForGroup();
            case "Department":
                return cellFormatForDepartment();
            case "Student":
                return cellFormatForStudent();
            case "Subject":
                return cellFormatForSubject();
            case "Visiting":
                return cellFormatForVisiting();
            case "Progress":
                return cellFormatForProgress();
            case "String": return null;
            case "StudentExtend":
                List<VariablesForCell> forCells = new ArrayList<>(cellFormatForStudent());
                forCells.add(new VariablesForCell("groupName", "Назва групи"));
                forCells.add(new VariablesForCell("departmentName", "Назва відділення"));
                return  forCells;
        }
        return null;
    }

    private static List<VariablesForCell> cellFormatForProgress() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер", null));
        forCells.add(new VariablesForCell("student", "Студент", null));
        forCells.add(new VariablesForCell("subject", "Предмет", null));
        forCells.add(new VariablesForCell("date", "Дата", null));
        forCells.add(new VariablesForCell("mark", "Оцінка", null));
        forCells.add(new VariablesForCell("kindOfLesson", "Тип заняття", null));
        return forCells;
    }

    private static List<VariablesForCell> cellFormatForVisiting() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер", null));
        forCells.add(new VariablesForCell("student", "Студент", null));
        forCells.add(new VariablesForCell("date", "Дата", null));
        forCells.add(new VariablesForCell("couple", "К-ість годин", null));
        forCells.add(new VariablesForCell("subject", "Предмет", null));
        forCells.add(new VariablesForCell("typeOfLesson", "Тип заняття", null));
        forCells.add(new VariablesForCell("reasonOfPass", "Причина пропуску", null));
        return forCells;
    }

    private static List<VariablesForCell> cellFormatForSubject() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер", null));
        forCells.add(new VariablesForCell("name", "Назва", null));
        forCells.add(new VariablesForCell("teacher", "Викладач", null));
        return forCells;
    }

    private static List<VariablesForCell> cellFormatForStudent() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер", null));
        forCells.add(new VariablesForCell("name", "Ім’я", null));
        forCells.add(new VariablesForCell("group", "Група", null));
        forCells.add(new VariablesForCell("addressOfResidence", "Адреса прописки", null));
        forCells.add(new VariablesForCell("addressOfLiving", "Адреса проживання", null));
        forCells.add(new VariablesForCell("benefit", "Пільги", null));
        forCells.add(new VariablesForCell("countOfReprimand", "К-ість пропусків", null));
        forCells.add(new VariablesForCell("dateOfBorn", "Дата народження", null));
        forCells.add(new VariablesForCell("telephoneNumber", "Телефон", "[0-9-]"));
        forCells.add(new VariablesForCell("moreInformation", "Додаткова інф.", null));
        return forCells;
    }

    private static List<VariablesForCell> cellFormatForDepartment() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер", null));
        forCells.add(new VariablesForCell("name", "Назва", null));
        forCells.add(new VariablesForCell("pibOfHead", "Завідувач відділення", null));
        return forCells;
    }

    private static List<VariablesForCell> cellFormatForGroup() {
        List<VariablesForCell> forCells = new ArrayList<>();
        forCells.add(new VariablesForCell("id", "Номер", null));
        forCells.add(new VariablesForCell("name", "Назва", "[A-Za-zА-Яа-яїЇіІєЄ0-9-]"));
        forCells.add(new VariablesForCell("codeOfSpeciality", "Код спеціальності", "[0-9.]"));
        forCells.add(new VariablesForCell("nameOfSpeciality", "Назва спеціальності", null));
        forCells.add(new VariablesForCell("course", "Курс", null));
        forCells.add(new VariablesForCell("curatorName", "Куратор", null));
        forCells.add(new VariablesForCell("countOfStudents", "К-ість студентів", null));
        forCells.add(new VariablesForCell("department", "Відділення", null));
        forCells.add(new VariablesForCell("subjectSet", "Предмети", null));
        return forCells;
    }

}
