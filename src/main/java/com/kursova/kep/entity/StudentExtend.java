package com.kursova.kep.entity;

/**
 * by Mr Skip on 21.03.2016.
 */

public class StudentExtend extends Student {

    private String groupName;
    private String departmentName;

    public StudentExtend() {
    }

    public StudentExtend(Student student){
        setName(student.getName());
        setGroup(student.getGroup());
        setAddressOfResidence(student.getAddressOfResidence());
        setAddressOfLiving(student.getAddressOfLiving());
        setBenefit(student.getBenefit());
        setCountOfReprimand(student.getCountOfReprimand());
        setDateOfBorn(student.getDateOfBorn());
        setTelephoneNumber(student.getTelephoneNumber());
        setMoreInformation(student.getMoreInformation());
    }

    public StudentExtend setGroupAndDepartmentNames(String groupName, String departmentName){
        this.groupName = groupName;
        this.departmentName = departmentName;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "StudentExtend{" +
                "id='" + id + '\'' +
                "groupName='" + groupName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
