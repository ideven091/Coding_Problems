package com.cleo.revision.effectiveJava.item2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Doubled {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        printdoubled(list);
        var doubled = list.stream().map(i ->i*2).collect(Collectors.toList());
        System.out.println(doubled);
        Function<Integer,Integer> square = x->x*x;
        list.stream().map(square).forEach(System.out::println);
    }

    public static void printdoubled(List<Integer> list){
        for(Integer i:list){
            System.out.println(i*2);
        }
    }
}
