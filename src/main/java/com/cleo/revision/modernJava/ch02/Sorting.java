package com.cleo.revision.modernJava.ch02;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {

    public static void main(String[] args) {
        var apples = Arrays.asList(
                new FilteringApples.Apple(80, FilteringApples.Color.GREEN),
                new FilteringApples.Apple(100, FilteringApples.Color.RED),
                new FilteringApples.Apple(150, FilteringApples.Color.GREEN)
        );
        apples.sort(new AppleComparatpr());
        System.out.println(apples);

        apples.set(1, new FilteringApples.Apple(90, FilteringApples.Color.GREEN));

        apples.sort((a1,a2)->a1.getWeight() - a2.getWeight());
        System.out.println(apples);
        apples.set(1,new FilteringApples.Apple(100, FilteringApples.Color.RED));
        apples.sort(Comparator.comparing(FilteringApples.Apple::getWeight));
        apples.sort((a1,a2)->a1.getWeight() - a2.getWeight());
        apples.set(1,new FilteringApples.Apple(80, FilteringApples.Color.RED));
        apples.sort(Comparator.comparing(FilteringApples.Apple::getWeight));
        System.out.println(apples);

    }

    static class AppleComparatpr implements Comparator<FilteringApples.Apple>{
        @Override
        public int compare(FilteringApples.Apple o1, FilteringApples.Apple o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }
}
