package com.cleo.designPatterns.adpaterDesignPattern;

public class Quack implements QuackBehaviour{
    @Override
    public void quack() {
        System.out.println("I quack");
    }
}
