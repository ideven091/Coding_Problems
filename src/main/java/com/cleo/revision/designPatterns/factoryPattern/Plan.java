package com.cleo.revision.designPatterns.factoryPattern;

public abstract class Plan {

    protected double rate;

    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(rate*units);
    }

}

class DomesticPlan extends Plan{
    @Override
    void getRate() {
        rate = 3.5;
    }
}

class CommercialPlan extends Plan{
    @Override
    void getRate() {
        rate = 7.5;
    }
}

class InstitutionalPlan extends Plan{
    @Override
    void getRate() {
        rate = 5.5;
    }
}

