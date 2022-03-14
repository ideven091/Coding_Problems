package com.cleo.revision.modernJava.ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BasicStream {

    public static void main(String[] args) {
        List<String> myList = List.of("I","am","doing","java","coding","a boolean", " a hello", "A");
        myList.stream()
                .map(String::toUpperCase)
                .filter(c ->c.startsWith("A"))
                //.map(String::toUpperCase)
                .sorted()
                .forEach(c -> System.out.print(c + " "));
        System.out.println();

        Arrays.asList("a1","a2","a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);


        /**
         * Another way
         */

        Stream.of("a1","a2","a3")
                .findFirst()
                .ifPresent(System.out::println);
    }
}
