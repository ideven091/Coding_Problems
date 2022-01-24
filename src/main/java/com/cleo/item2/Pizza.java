package com.cleo.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    public enum Topping{HAM, MUSHROOM,SAUSAGE,GARLIC}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        //To see
        EnumSet<Topping> toppings = EnumSet.allOf(Topping.class);

        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();

        protected abstract T self();

    }
    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }

}

class NYPizza extends Pizza{

    public enum Size{SMALL, MEDIUM, LARGE};

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }


        @Override
        Pizza build() {
            return new NYPizza(this);

        }

        @Override
        protected Builder self() {
            return this;
        }
    }

     NYPizza(Builder builder){
        super(builder);
        size = builder.size;
    }
}
