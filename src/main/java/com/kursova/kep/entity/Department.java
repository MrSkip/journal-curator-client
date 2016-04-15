package com.kursova.kep.entity;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

/**
 * by Mr Skip on 10.03.2016.
 */

public class Department extends BaseEntity{

    private Long id;
    private Date name;
    private String pibOfHead;

    public Department() {
    }

    public Department(
            Long id,
            Date name,
            String pibOfHead
    ) {
//        this.id = new SimpleLongProperty(id);
        this.id = id;
        this.name = name;
        this.pibOfHead = pibOfHead;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getName() {
        return name;
    }

    public void setName(Date name) {
        this.name = name;
    }

    public String getPibOfHead() {
        return pibOfHead;
    }

    public void setPibOfHead(String pibOfHead) {
        this.pibOfHead = pibOfHead;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name=" + name +
                ", pibOfHead=" + pibOfHead +
                '}';
    }
}
