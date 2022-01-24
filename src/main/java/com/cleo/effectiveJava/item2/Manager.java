package com.cleo.effectiveJava.item2;

public class Manager extends Employee{

    public enum POSITIONS{DIRECTOR, CEO, CHIEF}

    public static class Builder extends Employee.Builder{

        private final boolean working;

        public Builder(String name, String grade) {
            super(name, grade);
            working = true;
        }

        public Builder working(){

            return this;

        }

    }

    public Manager(Employee.Builder builder) {
        super(builder);

    }
}
