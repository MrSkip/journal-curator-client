package com.kursova.kep.entity;

import java.sql.Date;

/**
 * by Mr Skip on 08.03.2016.
 */

public class Progress extends BaseEntity{

    private Student student;
    private Subject subject;

    private Date date;
    private Integer mark;
    private String kindOfLesson;

    public Progress() {
    }

    public Progress(
            Student student,
            Subject subject,
            Date date,
            Integer mark,
            String kindOfLesson
    ) {
        this.student = student;
        this.subject = subject;
        this.date = date;
        this.mark = mark;
        this.kindOfLesson = kindOfLesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getKindOfLesson() {
        return kindOfLesson;
    }

    public void setKindOfLesson(String kindOfLesson) {
        this.kindOfLesson = kindOfLesson;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "student=" + student.getName() +
                ", subject=" + subject.getName() +
                ", date=" + date +
                ", mark=" + mark +
                ", kindOfLesson='" + kindOfLesson + '\'' +
                '}';
    }
}
