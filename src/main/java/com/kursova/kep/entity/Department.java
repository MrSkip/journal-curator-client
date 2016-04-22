package com.kursova.kep.entity;

/**
 * by Mr Skip on 10.03.2016.
 */

public class Department extends BaseWithName{
    private String pibOfHead;

    public Department() {
    }

    public Department(
            Long id,
            String name,
            String pibOfHead
    ) {
        this.id = id;
        this.name = name;
        this.pibOfHead = pibOfHead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
