package com.cleo.designPatterns.adpaterDesignPattern;

public class NoFlyWay implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("I cannot fly");
    }
}
