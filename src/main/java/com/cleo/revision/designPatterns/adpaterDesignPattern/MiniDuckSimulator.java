package com.cleo.revision.designPatterns.adpaterDesignPattern;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.setFly(new FlyRocketBehaviour());
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFly(new FlyRocketBehaviour());
        model.performFly();
    }
}
