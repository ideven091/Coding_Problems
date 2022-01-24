package com.cleo.java_coding_problems.item1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicates {

    public static void duplicateCharactersV1(String str){
        Map<Character, Integer> map= new HashMap<>();

        for(char c: str.toCharArray()){
            if(map.containsKey(c)){
                int value = map.get(c);
                map.put(c,++value);
            }else{
                map.put(c,1);
            }
        }
        map.entrySet()
                .forEach(ch ->System.out.print(ch +  " "));
    }

    public static void countingFirstNonRepeatedCharacter(String str){
        Map<Character, Integer> map = new HashMap<>();

        for(char c: str.toCharArray()){
            map.compute(c,(k,v)->v==null?1:++v);
        }
        map.entrySet().forEach(System.out::println);
      //  System.out.println();
        map.entrySet()
                .stream()
                .filter(v -> v.getValue()==1)
                .findFirst()
                .ifPresent(System.out::println);

    }

    public static String firstNonRepeatedCharacterV2(String str){

        Map<Integer, Long> chs = str.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

        return String.valueOf(Character.toChars(chs.entrySet()
                .stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse((int) Character.MIN_VALUE)));
    }

    /**
     *
     * @param str Input String
     * @return the most frequent occurring character
     */
    public static char countingMostRepeatedCharacter(String str){
        return 'a';
    }

    public static void main(String[] args) {
        String str = "DavidaD";
        duplicateCharactersV1(str);
        var time1 = System.nanoTime();
        countingFirstNonRepeatedCharacter(str);
        var time2 = System.nanoTime();

        var diff = time2 - time1;
        //System.out.println();
        String s = firstNonRepeatedCharacterV2(str);
        //System.out.println("First Non Repeated Character is: " + firstNonRepeatedCharacterV2(str));
        var time3 = System.nanoTime();
        var diff2 = time3 - time2;
        System.out.println("First operation took " + diff + " Second took " + diff2 + " difference is " + (diff2 - diff));
    }
}
