package com.cleo.revision.Hackathon.practice;

import java.util.Date;

public abstract class Person {

    private String firstName, lastName;
    private Date date_of_birth;

    public enum GENDER{MALE, FEMALE, DO_NOT_WANT_TO_DISCLOSE};

    private String profession;

    public abstract static class Builder<T extends Builder<T>>{


    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
