package com.cleo.item2;

public class Employee {

    private final String name;

    private final int age;

    private final String grade;

    public static class Builder{

        private final String name;

        private final String grade;

        public Builder(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }

        private int age = 0;

        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }

    }
    public Employee(Builder builder){
        name = builder.name;
        grade = builder.grade;
        age = builder.age;
    }

    public static void main(String[] args) {

        Employee employee = new Employee.Builder("John","X").age(18).build();
        System.out.println(employee);
    }

    public String toString(){
        return this.name + " " + this.grade;
    }
}
