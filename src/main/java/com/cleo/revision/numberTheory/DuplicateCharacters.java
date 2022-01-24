package com.cleo.revision.numberTheory;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {

    public static void count_distinct_duplicate(String str){
        int total = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put(str.charAt(0),1);


        for(int j=1;j<str.length();j++){
            char c = str.charAt(j);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c,++count);
            }else{
                map.put(c,1);
            }
        }


        System.out.println(map);

   }

    /*
     *To do -> Implement HashMap
     *
     */

    public static void main(String[] args) {
        String str = "Jetbrains Intellij Idea safdidlajfal sihfjaksdjhf, valkshif als.fhv da/esfjdkaAFESDKLA:DLFSGV Aslfdj lfsjga voilfdv";
        count_distinct_duplicate(str);
    }
}
