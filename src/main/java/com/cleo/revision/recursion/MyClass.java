package com.cleo.revision.recursion;

import java.io.IOException;

public class MyClass extends Thread{

    private boolean stop = false;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i + " \t");
            if(stop)return;
        }
    }

    public static void main(String[] args) throws IOException {
        MyClass obj = new MyClass();
        Thread t = new Thread(obj);
        t.start();
        System.in.read();
        obj.stop = true;
        System.out.println(t.getContextClassLoader());
        System.out.println(t.getState());
    }
}
