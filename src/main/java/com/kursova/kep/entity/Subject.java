package com.kursova.kep.entity;

/**
 * by Mr Skip on 08.03.2016.
 */

public class Subject extends BaseEntity{

    private String name;
    private String teacher;

    public Subject() {
    }

    public Subject(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public Subject(Subject subject){
        name = subject.name;
        teacher = subject.teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
