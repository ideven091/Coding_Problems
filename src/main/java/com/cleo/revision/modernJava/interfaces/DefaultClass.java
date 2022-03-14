package com.cleo.revision.modernJava.interfaces;

public class DefaultClass implements Default{

    private final int PI = 3;

    @Override
    public String getName() {
        return "admin";
    }

    @Override
    public int defaultMethod(int value) {
        //return Default.super.defaultMethod(value);
        return PI + value;
    }

    public static void main(String[] args) {
        DefaultClass defaultClass = new DefaultClass();
        System.out.println( defaultClass.defaultMethod(10));
        System.out.println(defaultClass.getName());
    }
}
