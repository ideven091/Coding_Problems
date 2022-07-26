package com.cleo.revision.dataStructures.backtracking;

import java.util.List;

public class Apples {

    private String name;
    private enum Color{
        RED, GREEN
    }

    public Apples(String name, Color color) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<Apples> apples = List.of(
                new Apples("delicious", Color.GREEN),
                new Apples("safeda", Color.RED)
        );
        apples.stream()
                .filter(c -> c.getName().equals("delicious"))
                .forEach(n -> System.out.print(n + " "));
    }
    public String toString(){
        return getName();
    }
}
