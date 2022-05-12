package com.cleo.revision.modernJava.ch02;

public class MeaningOfThis {

    public final int doIt = 6;

    public void doIT(){
        int value = 4;
        Runnable r = new Runnable() {
            public final int value=5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {

        MeaningOfThis m = new MeaningOfThis();
        m.doIT();
    }
}
