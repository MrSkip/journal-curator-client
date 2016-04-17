package com.kursova.kep.entity;

/**
 * by Mr Skip on 10.03.2016.
 */

public class Department extends BaseEntity{

    private Long id;
    private String name;
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

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
