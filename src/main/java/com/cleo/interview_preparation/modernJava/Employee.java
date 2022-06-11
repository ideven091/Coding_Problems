package com.cleo.interview_preparation.modernJava;

import com.cleo.revision.modernJava.ch02.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private String name;
    private String departmentId;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, String departmentId, int age) {
        this.name = name;
        this.departmentId = departmentId;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate){
        List<Employee> employees1 = new ArrayList<>();
        for(var e:employees){
            if(predicate.test(e))
                employees1.add(e);
        }
        return employees1;

    }
    public static List<Employee> filterByAge(List<Employee> employees){
        return employees.stream().filter(e->e.getAge()<30).collect(Collectors.toList());
    }

    private final static List<Employee> employeeList = List.of(
            new Employee("Deven","Manager",24),
            new Employee("John","Payroll",36),
            new Employee("Monica","Finance",22),
            new Employee("Rachael","Finance",41),
            new Employee("Ross","Idiot",51),
            new Employee("Joey","Acting",36)

            );

    public String toString(){
        return getName();
    }
    public static void main(String[] args) {
        System.out.println(filterEmployees(employeeList,(Employee e)->e.getAge()<30));
        System.out.println(filterEmployees(employeeList,(Employee e)->e.getDepartmentId().equals("Finance")));
        employeeList.stream().filter(e->e.getAge()<30).forEach(e-> System.out.print(e +" "));
       /* System.out.println(
                employeeList
                        .stream()
                        .map(employee -> {
                            return employeeList.stream().filter(e->e.getAge()>40);
                        })



                        .sorted()
                        .collect(Collectors.toList())

                );*/
        long count = employeeList.stream().map(d->1).reduce(0,Integer::sum);
        System.out.println(count);
    }


}
