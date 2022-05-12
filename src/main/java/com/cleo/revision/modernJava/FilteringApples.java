package com.cleo.revision.modernJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples {

    public static class Apple{

        private int weight=0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @SuppressWarnings("boxed")
        @Override
        public String toString(){
            return String.format("Apple color='%s', weight='%d'", color, weight);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(40, "blue"),
                new Apple(120, "green")
        );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        var greenApples2 = filterApples(inventory, (Apple a)->
                a.getColor().equalsIgnoreCase("GREEN"));

        System.out.println(greenApples2);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        var weirdApples = filterApples(inventory, (Apple a)->a.getColor().equalsIgnoreCase("GREEN") || a.getWeight()<100);
        var apples = inventory.stream().filter((Apple a) -> a.getWeight() > 100).collect(Collectors.toList());

        System.out.println(weirdApples);
        System.out.println("Streaming " + apples);
        /* To see */
        Comparator<Apple> byWeight = Comparator.comparingInt(Apple::getWeight);
        inventory.sort(byWeight);
        System.out.println(inventory);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(apple.getColor().equals("green"))
                result.add(apple);
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>100;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }


}
