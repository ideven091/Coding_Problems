package com.cleo.revision.modernJava.practice;

import java.util.Date;
import java.util.Objects;

public abstract class Engine {

    private String build, type;
    private Date date_of_manufacturing;
    private String Owner;

    abstract static class Builder<T extends Builder<T>>{


        protected abstract T self();

        abstract Engine build();


    }
    Engine(Builder<?> builder){

    }
}

class MahindraEngine extends Engine{

    private String owner;

    public static class Builder extends Engine.Builder<Builder>{

        private final long gallons_per_km;

        private final String owner;

        public Builder(long gallons_per_km, String owner){
            this.gallons_per_km = Objects.requireNonNull(gallons_per_km);
            this.owner = Objects.requireNonNull(owner);
        }

        @Override
        Engine build(){
            return new MahindraEngine(this);
        }
        @Override
        protected Builder self(){
            return this;
        }

    }
    MahindraEngine(Builder builder){
        super(builder);
        owner =builder.owner;

    }

    public String toString(){
        return this.owner;
    }

    public static void main(String[] args) {
        Engine engine = new MahindraEngine.Builder(12,"Admin").build();
        System.out.println(engine);
    }
}
