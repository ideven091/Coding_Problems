package com.cleo.interview_preparation.modernJava;

public class Departments {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Departments() {
    }

    public Departments(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
