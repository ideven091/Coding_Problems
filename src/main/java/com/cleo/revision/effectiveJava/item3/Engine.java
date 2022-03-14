package com.cleo.revision.effectiveJava.item3;

public class Engine {

    private static final Engine INSTANCE = new Engine();

    private Engine(){}

    public static Engine getINSTANCE() {
        return INSTANCE;
    }

    public float milesPerHour(int kiloMeters){
        return (float) 1.28*kiloMeters;
    }
}
