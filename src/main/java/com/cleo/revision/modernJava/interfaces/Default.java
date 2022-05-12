package com.cleo.revision.modernJava.interfaces;

@FunctionalInterface
public interface Default {

    String name = "abcdef";
    int DEFAULT_VALUE=10000;

    String getName();

    default int defaultMethod(int value){
        return DEFAULT_VALUE + value;

    }

}
