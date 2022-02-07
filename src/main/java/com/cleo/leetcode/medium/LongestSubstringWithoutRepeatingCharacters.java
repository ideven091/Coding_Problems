package com.cleo.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int size = 0;
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
          //  System.out.println(s.charAt(i));
            if(i==s.length()-1){
                if(map.containsKey(s.charAt(i))) {
                    System.out.println(s.charAt(i));

                    break;
                }
            }
            if(map.containsKey(s.charAt(i))){
                int n = map.get(s.charAt(i));


                    for (int j = 0; j < n; j++) {
                        map.remove(s.charAt(j),j);
                    }

            }
                map.put(s.charAt(i),i);
        //    System.out.println(map);

        }

            size = map.size();
        return size;
    }

    public static int lengthOfString(String s, int n){
        if(s==null)
            return 0;
        if(s.length()==1)
            return 1;
        if((1+lengthOfString(s,n-1)+s.charAt(n-1))>lengthOfString(s,n))
            return 1+lengthOfString(s,n-1);

        return 0;
    }

    public static int longestSubStringLength(String s){
        if(s==null)
            return 0;
        if(s.length()==1)
            return 1;


        return 0;
    }

    public static int longestSubSequence(List<Character> str, int n){
        if(n<=0)
            return 0;
        else if((1+longestSubSequence(str,n-2))>longestSubSequence(str,n-1))
            return 1+longestSubSequence(str, n-1);
        else
            return Math.max(longestSubSequence(str,n-1),longestSubSequence(str,n-2));
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str));
        var name = List.of('D','E','V','E','N','G','H');
      //  System.out.println(longestSubSequence(name,name.size()));
    }
}
