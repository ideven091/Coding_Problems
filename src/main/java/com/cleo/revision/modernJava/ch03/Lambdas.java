package com.cleo.revision.modernJava.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lambdas {

    public static void main(String[] args) throws Exception{
        Callable<Integer> c = () -> 42;
        System.out.println(c.call());
        Object o = (Runnable) () -> {
            System.out.println("I am tired");
        };
       // System.out.println(o.equals(o));

        List<String> dishes = List.of("Meat", "Pork", "Fish", "Other");

        var a = dishes.stream().map(String::length).filter(length -> length >4).collect(Collectors.toList());
        System.out.println(a);

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x*2;
        Function<Integer, Integer> h =f.andThen(g);
        int result = h.apply(1);
        System.out.println(result);
        //System.out.println(integrate());
        String oneLine = processFile(BufferedReader::readLine);
        String twoLines = processFile((BufferedReader br)-> br.readLine() + "\n" + br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLines);
        System.out.println(integrate((double x)->x +10, 2, 4));
    }

    public static double integrate(DoubleFunction<Double> f, double a, double b ){
        return (f.apply(a) + f.apply(b))*(b-a)/2.0;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/deven/data.txt"))){
            return p.process(br);
        }
    }
}
