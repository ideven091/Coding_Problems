package com.cleo.revision.designPatterns.adpaterDesignPattern;

public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehaviour = new NoFlyWay();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a model Duck");
    }
}
