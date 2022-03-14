package com.cleo.revision.modernJava.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        var apples = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(100, Color.RED),
                new Apple(150, Color.GREEN)
        );
        var greenApples = filter(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getColor() == Color.GREEN;
            }
        });

       Runnable r1 = () -> System.out.println("Bored");
       r1.run();
       process(() -> System.out.println("Need rest"));
        System.out.println(greenApples);
    }

    public static void process(Runnable r){
        r.run();
    }
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
        var result = new ArrayList<Apple>();
        for(var a: inventory){
            if(p.test(a)){
                result.add(a);
            }
        }
        return result;
    }



    enum Color{RED, GREEN}

    public static class Apple{

        private int weight=0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @SuppressWarnings("boxed")
        @Override
        public String toString(){
            return String.format("Apple color='%s', weight='%d'", color, weight);
        }
    }

    public interface ApplePredicate{

        boolean test(Apple a);

    }

    static class AppleWeightPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple a){
            return a.getWeight() > 100;
        }
    }

    static class AppleColorPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple a) {
            return a.getColor() == Color.GREEN;
        }
    }
}
