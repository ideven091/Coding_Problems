package com.cleo.revision.java_coding_problems.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NullReferences {

    private static final List<Integer> numbers = Arrays.asList(1,2,null,5,7,9, 10,12,null);

    public static List<Integer> evenNumbers(List<Integer> numbers){
        var output = new ArrayList<Integer>();
        return numbers.stream().filter(Objects::nonNull).filter(n ->n%2==0).collect(Collectors.toList());
    }

    public static boolean isPrime(int n){
        if(n == 1)
            return false;
        for (int i = 2; i < n/2; i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static int sum_numbers(List<Integer> numbers){
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue).sum();
    }

    public static int sum_prime_numbers(List<Integer> numbers){
        var output = numbers.stream()
                .filter(Objects::nonNull).collect(Collectors.toList());

        int sum = 0;
        for(Integer a: output){
            if(isPrime(a))
                sum += a;
        }
        return sum;
    }

    public static boolean containsNull(List<Integer> numbers){
        return numbers.stream()
                .anyMatch(Objects::isNull);
    }

    public static void main(String[] args) {
        System.out.println(evenNumbers(numbers));

        System.out.println(sum_prime_numbers(numbers));
        System.out.println(sum_numbers(numbers));
        System.out.println(containsNull(numbers));
    }
}
