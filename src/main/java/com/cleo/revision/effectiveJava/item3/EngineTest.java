package com.cleo.effectiveJava.item3;

public class EngineTest {


    /**
     *
     * Both engine and e are in the same memory location
     */
    public static void main(String[] args) {
        Engine engine = Engine.getINSTANCE();
        System.out.println(engine.milesPerHour(200));

        Engine e = Engine.getINSTANCE();
        System.out.println(e.milesPerHour(300));
        System.out.println(engine.equals(e));
        System.out.println(engine == e);
        System.out.println(engine.hashCode());
        System.out.println(e.hashCode());

    }
}
