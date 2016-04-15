package com.kursova.kep.entity;

/**
 * by Mr Skip on 08.03.2016.
 */

public class Group extends BaseEntity{

    private String name;
    private String codeOfSpeciality;
    private String nameOfSpeciality;
    private Integer course;
    private String curatorName;
    private Integer countOfStudents;
    private Department department;

    public Group() {
    }

    public Group(
            String name,
            String codeOfSpeciality,
            String nameOfSpeciality,
            Integer course,
            String curatorName,
            Integer countOfStudents,
            Department idDepartment
    ) {
        this.name = name;
        this.codeOfSpeciality = codeOfSpeciality;
        this.nameOfSpeciality = nameOfSpeciality;
        this.course = course;
        this.curatorName = curatorName;
        this.countOfStudents = countOfStudents;
        this.department = idDepartment;
    }

    public Group setGroup(Group group){
        id = group.id;
        name = group.name;
        codeOfSpeciality = group.codeOfSpeciality;
        nameOfSpeciality = group.nameOfSpeciality;
        course = group.course;
        curatorName = group.curatorName;
        countOfStudents = group.countOfStudents;
        department = group.department;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeOfSpeciality() {
        return codeOfSpeciality;
    }

    public void setCodeOfSpeciality(String codeOfSpeciality) {
        this.codeOfSpeciality = codeOfSpeciality;
    }

    public String getNameOfSpeciality() {
        return nameOfSpeciality;
    }

    public void setNameOfSpeciality(String nameOfSpeciality) {
        this.nameOfSpeciality = nameOfSpeciality;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getCuratorName() {
        return curatorName;
    }

    public void setCuratorName(String curatorName) {
        this.curatorName = curatorName;
    }

    public int getCountOfStudents() {
        return countOfStudents;
    }

    public void setCountOfStudents(int countOfStudents) {
        this.countOfStudents = countOfStudents;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codeOfSpeciality='" + codeOfSpeciality + '\'' +
                ", nameOfSpeciality='" + nameOfSpeciality + '\'' +
                ", course=" + course +
                ", curatorName='" + curatorName + '\'' +
                ", countOfStudents=" + countOfStudents +
                ", idDepartment=" + (getDepartment() != null ? getDepartment().getId() : "null") +
//                ", studentSet=" + studentSet +
//                ", subjectSet=" + subjectSet +
                '}';
    }
}

