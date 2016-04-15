package com.kursova.kep.entity;

import java.sql.Date;

/**
 * by Mr Skip on 08.03.2016.
 */

public class Visiting extends BaseEntity{

    private Student student;

    private Date date;
    private Integer couple;
    private Subject subject;
    private String typeOfLesson;
    private String reasonOfPass;

    public Visiting() {
    }

    public Visiting(Student student,
                    Date date,
                    Integer couple,
                    Subject idSubject,
                    String typeOfLesson,
                    String reasonOfPass) {
        this.student = student;
        this.date = date;
        this.couple = couple;
        this.subject = idSubject;
        this.typeOfLesson = typeOfLesson;
        this.reasonOfPass = reasonOfPass;
    }

    public Visiting(Visiting visiting){
        this.student = visiting.student;
        this.date = visiting.date;
        this.couple = visiting.couple;
        this.subject = visiting.subject;
        this.typeOfLesson = visiting.typeOfLesson;
        this.reasonOfPass = visiting.reasonOfPass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCouple() {
        return couple;
    }

    public void setCouple(Integer couple) {
        this.couple = couple;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getTypeOfLesson() {
        return typeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    public String getReasonOfPass() {
        return reasonOfPass;
    }

    public void setReasonOfPass(String reasonOfPass) {
        this.reasonOfPass = reasonOfPass;
    }

    @Override
    public String toString() {
        return "Visiting{" +
                "student=" + student.getName() +
                ", date=" + date +
                ", couple=" + couple +
                ", subject=" + subject.getName() +
                ", typeOfLesson='" + typeOfLesson + '\'' +
                ", reasonOfPass='" + reasonOfPass + '\'' +
                '}';
    }
}
