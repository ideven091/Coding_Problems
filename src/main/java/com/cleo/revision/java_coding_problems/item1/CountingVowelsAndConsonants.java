package com.cleo.revision.java_coding_problems.item1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingVowelsAndConsonants {

    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

    public static void countVowelsAndConsonants(String str){

        str = str.toLowerCase();
        int vowels = 0, consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(allVowels.contains(ch))
                vowels++;
            else if((ch>='a' && ch <= 'z'))
                consonants++;
        }
        System.out.println("Consonants= "+ consonants + " vowels= " + vowels);
    }

    public static void countVowelsAndConsonantsV2(String str){
        str = str.toLowerCase();

        long vowels = str.chars()
                .filter(c ->allVowels.contains((char)c))
                .count();
        long consonants = str.chars()
                .filter(c ->!allVowels.contains((char)c))
                .filter(ch-> (ch >='a' && ch<='z'))
                .count();

        System.out.println("Consonants= "+ consonants + " vowels= " + vowels);
    }
    public static void countVowelsAndConsonantsV3(String str){
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char)c)
                .filter(ch ->(ch>='a' && ch <='z'))
                .collect(Collectors.partitioningBy(allVowels::contains,Collectors.counting()));
        System.out.println("Consonants= "+ result.get(false)+ " vowels= " + result.get(true));

    }

    public static void main(String[] args) {
        String str = "Jack is a good boy";

        countVowelsAndConsonants(str);

        countVowelsAndConsonantsV2(str);

        countVowelsAndConsonantsV3(str);
    }



    }
