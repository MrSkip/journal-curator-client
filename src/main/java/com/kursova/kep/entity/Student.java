package com.kursova.kep.entity;

import java.sql.Date;

/**
 * by Mr Skip on 08.03.2016.
 */

public class Student extends BaseWithName{

    private Group group;
    private String addressOfResidence;
    private String addressOfLiving;
    private String benefit;
    private Integer countOfReprimand;
    private Date dateOfBorn;
    private String telephoneNumber;
    private String moreInformation;

    public Student() {
    }

    public Student(
            String name,
            Group idGroup,
            String addressOfResidence,
            String addressOfLiving,
            String benefit,
            int countOfReprimand,
            Date dateOfBorn,
            String telephoneNumber,
            String moreInformation
    ) {
        this.name = name;
        this.group = idGroup;
        this.addressOfResidence = addressOfResidence;
        this.addressOfLiving = addressOfLiving;
        this.benefit = benefit;
        this.countOfReprimand = countOfReprimand;
        this.dateOfBorn = dateOfBorn;
        this.telephoneNumber = telephoneNumber;
        this.moreInformation = moreInformation;
    }

    public Student setStudent(Student student){
        name = student.name;
        group = student.group;
        addressOfResidence = student.addressOfResidence;
        addressOfLiving = student.addressOfLiving;
        benefit = student.benefit;
        countOfReprimand = student.countOfReprimand;
        dateOfBorn = student.dateOfBorn;
        telephoneNumber = student.telephoneNumber;
        moreInformation = student.moreInformation;
        return this;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getAddressOfResidence() {
        return addressOfResidence;
    }

    public void setAddressOfResidence(String addressOfResidence) {
        this.addressOfResidence = addressOfResidence;
    }

    public String getAddressOfLiving() {
        return addressOfLiving;
    }

    public void setAddressOfLiving(String addressOfLiving) {
        this.addressOfLiving = addressOfLiving;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public Integer getCountOfReprimand() {
        return countOfReprimand;
    }

    public void setCountOfReprimand(Integer countOfReprimand) {
        this.countOfReprimand = countOfReprimand;
    }

    public Date getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(Date dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMoreInformation() {
        return moreInformation;
    }

    public void setMoreInformation(String moreInformation) {
        this.moreInformation = moreInformation;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", addressOfResidence='" + addressOfResidence + '\'' +
                ", addressOfLiving='" + addressOfLiving + '\'' +
                ", benefit='" + benefit + '\'' +
                ", countOfReprimand=" + countOfReprimand +
                ", dateOfBorn=" + dateOfBorn +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", moreInformation='" + moreInformation + '\'' +
                '}';
    }
}
