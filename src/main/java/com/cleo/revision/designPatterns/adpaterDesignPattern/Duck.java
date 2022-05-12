package com.cleo.revision.designPatterns.adpaterDesignPattern;

public abstract class Duck {

    private String name;

    protected FlyBehaviour flyBehaviour;
    protected QuackBehaviour quackBehaviour;

    public  void performFly(){
        flyBehaviour.fly();

    }
    public void performQuack(){
        quackBehaviour.quack();
    }

    public void setFly(FlyBehaviour canFly) {
        this.flyBehaviour = canFly;
    }

    public void setQuack(QuackBehaviour canQuack) {
        this.quackBehaviour = canQuack;
    }

    public Duck(String name) {
        this.name = name;
    }

    public Duck() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public abstract void display();


}
