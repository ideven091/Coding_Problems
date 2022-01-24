package com.cleo.item3;


/**
 * Enforcing singleton with public static final and private constructor
 */
public class Elvis {

    public static int i = 0;
    public static final Elvis INSTANCE = new Elvis();

    private Elvis(){
        i++;
    }

    public  void hello_elvis(){
        System.out.println("Hello Elvis");
    }

    public int counter(){
        //  i++;
        return i;
    }

    public Object readResolve(){
        return INSTANCE;
    }
}
