package com.cleo.item3;

public class Peter {

    public static void main(String[] args) {
        Elvis instance = Elvis.INSTANCE;
        instance.hello_elvis();
        System.out.println(instance.counter());

        Elvis e = Elvis.INSTANCE;
        System.out.println(e.counter());
    }
}
