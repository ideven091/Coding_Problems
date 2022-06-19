package com.cleo.revision.effectiveJava.item2;


//Builder Pattern
public class Calzone extends Pizza{

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder>{
        private boolean sauceInside = false;
        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }
        @Override
            public Calzone build(){
                return new Calzone(this);
            }
            @Override
        protected Builder self(){
            return this;
            }

    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static void main(String[] args) {

        NYPizza nyPizza = (NYPizza) new NYPizza.Builder(NYPizza.Size.SMALL).addTopping(Topping.SAUSAGE).addTopping(Topping.HAM).build();
        var calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().self();
        System.out.println(calzone.addTopping(Topping.HAM).toppings.toString());
        calzone.toppings.add(Topping.MUSHROOM);
        var dominos = new Calzone.Builder().addTopping(Topping.GARLIC).self();
        //dominos.build();
        System.out.println(dominos.toppings.toString());
    }


}
