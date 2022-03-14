package com.cleo.revision.designPatterns.adpaterDesignPattern;

public class MallardDuck extends Duck{

    private String name;
    public MallardDuck() {
        super();
        this.name = "Mallard Duck";
    }


    @Override
    public void performFly() {
        System.out.println("Mallard duck flies");
    }

    @Override
    public void display() {

        System.out.println(name);
        performFly();

    }


}
