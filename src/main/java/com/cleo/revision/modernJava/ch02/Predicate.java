package com.cleo.revision.modernJava.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T t);
}
@FunctionalInterface
interface Consumer<T>{
    public void accept(T t);
}

class Filter<T> {
    public static  <T>  List<T> filter(List<T> list, Predicate<T> p) {
        var results = new ArrayList<T>();
        for(T t : list){
            if(p.test(t))
                results.add(t);
        }
        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T t: list){
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        Predicate<String> nonEmpty = (String s) -> !s.isEmpty();
        List<String> nonEmptyList = filter(List.of("Hi","","There"),nonEmpty);
        List<String> nonEmptyStrings = List.of("Hi","","There");
        forEach(Arrays.asList(1,2,3,4,5), System.out::println);

        // System.out.println(Objects.nonNull(nonEmptyStrings));
        System.out.println(nonEmptyList);
        nonEmptyStrings.stream()
        .forEach(n ->{System.out.print(n + " ");});
        System.out.println();
    }
}