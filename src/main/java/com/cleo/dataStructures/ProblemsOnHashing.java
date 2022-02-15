package com.cleo.dataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ProblemsOnHashing {

    public void duplicateCharacters(String s, int length){
       Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c))
                map.put(c,1);
            else{
                int value = map.get(c);
                map.put(c,++value);
            }
        }
        for(Map.Entry<Character,Integer> m: map.entrySet()){
            System.out.println(m.getKey()+ " "  + m.getValue());
        }

    }

    public static void countingDuplicateCharacters(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.compute(c,(k,v)->v==null?1:++v);
        }
        for(var m: map.entrySet()){
            System.out.println(m.getKey()+ " " + m.getValue());
        }
    }

    public static char firstNonRepeatedCharacter(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c))
                map.put(c,1);
            else{
                int value = map.get(c);
                map.put(c,++value);
            }
        }
        for(Map.Entry<Character,Integer> m: map.entrySet()){
            if(m.getValue()==1)
                return m.getKey();
        }
        return '0';

    }

    public static boolean ifOnlyDigits(String s){
        //return s.chars().allMatch(Character::isDigit);

       return s.matches("[0-9]+");

    }
    public static boolean containsOnlyDigits(String str) {
        return str.matches("[0-9]+");
    }
    public static void main(String[] args) {
        new ProblemsOnHashing().duplicateCharacters("Deven",5);
        countingDuplicateCharacters("Deven");
        System.out.println(firstNonRepeatedCharacter("Deven"));
        System.out.println(ifOnlyDigits("1234A"));
        System.out.println(ifOnlyDigits("123123"));
        System.out.println(containsOnlyDigits("123123"));


    }
}


