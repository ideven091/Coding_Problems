package com.cleo.revision.recursion;

public class Current {

    public static void main(String[] args) {
        System.out.println("Current Thread is");
        Thread t = Thread.currentThread();
        System.out.println(t + " Name: " + t.getName());
    }
}
