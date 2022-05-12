package com.cleo.revision.modernJava.ch03;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class    Dish {

    enum TYPE {DAAL, PANEER, MEAT, FISH, OTHER}

    private String name;
    private final boolean vegetarian;
    private float calories;
    private TYPE type;
    private String cooked_by;

    public String getCooked_by() {
        return cooked_by;
    }

    public void setCooked_by(String cooked_by) {
        this.cooked_by = cooked_by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public Dish(String name, boolean vegetarian, float calories, TYPE type, String cooker) {
        this.name = name;
        this.calories = calories;
        this.type = type;
        this.cooked_by = cooker;
        this.vegetarian = vegetarian;
    }


    @Override
    public String toString(){
        return String.format("Dish is of %s with calories %s and is cooked by %s", getName(), getCalories(), getCooked_by());
    }
   public static List<Dish> dishes = List.of(
            new Dish("daal makhani", true,420, TYPE.DAAL, "Deven"),
            new Dish("paneer makhani", true,380, TYPE.PANEER, "Alex"),
            new Dish("pork", false, 800, TYPE.MEAT,"Anchit"),
            new Dish("beef", false, 700, Dish.TYPE.MEAT, "Deven"),
            new Dish("chicken", false, 400, Dish.TYPE.MEAT, "Suzan"),
            new Dish("french fries", true, 530, Dish.TYPE.OTHER, "Aanchal"),
            new Dish("rice", true, 350, Dish.TYPE.OTHER, "Mom"),
            new Dish("season fruit", true, 120, Dish.TYPE.OTHER,"Mom"),
            new Dish("pizza", true, 550, Dish.TYPE.OTHER,"Dominos"),
            new Dish("prawns", false, 400, Dish.TYPE.FISH,"Pizza Hut"),
            new Dish("salmon", false, 450, Dish.TYPE.FISH,"Someone")

    );
    public static void main(String[] args) {
     /*   var dishes = List.of(
                new Dish("daal makhani", true,420, TYPE.DAAL, "Deven"),
                new Dish("paneer makhani", true,380, TYPE.PANEER, "Alex"),
                new Dish("pork", false, 800, TYPE.MEAT,"Anchit"),
                new Dish("beef", false, 700, Dish.TYPE.MEAT, "Deven"),
                new Dish("chicken", false, 400, Dish.TYPE.MEAT, "Suzan"),
                new Dish("french fries", true, 530, Dish.TYPE.OTHER, "Aanchal"),
                new Dish("rice", true, 350, Dish.TYPE.OTHER, "Mom"),
                new Dish("season fruit", true, 120, Dish.TYPE.OTHER,"Mom"),
                new Dish("pizza", true, 550, Dish.TYPE.OTHER,"Dominos"),
                new Dish("prawns", false, 400, Dish.TYPE.FISH,"Pizza Hut"),
                new Dish("salmon", false, 450, Dish.TYPE.FISH,"Someone")

                );*/
        Map<TYPE, List<Dish>> dishesByType = dishes.stream().collect(Collectors.groupingBy(Dish::getType));

        System.out.println(dishesByType);

        List<String> lowCaloriesDishes = dishes.stream()
                .filter(d -> d.getCalories() < 500)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(lowCaloriesDishes);


    }
}
