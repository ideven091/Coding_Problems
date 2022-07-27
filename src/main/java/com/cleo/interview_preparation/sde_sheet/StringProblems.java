package com.cleo.interview_preparation.sde_sheet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringProblems {
    static int longestSubstrDistinctChars(String S){
        // code here
      //  int[] dp = new int[S.length()+1];
    //    dp[0]=0;
        int count=1,length=1,max=0;
        StringBuilder str = new StringBuilder();
      //  str.append(S.charAt(0));
        for(char c:S.toCharArray()){
            if(str.indexOf(String.valueOf(c))==-1) {
               // str = new StringBuilder();
              str.append(c);
              length=str.length();
                if(max<=length)
                    max=length;
         //       dp[count++]=1+dp[count-1];
            }
            else {
                str = new StringBuilder();
                str.append(c);
                length=1;

           //     dp[count++]=dp[count-1];
            }
        }
       return max;

    }

    static int longestSubString(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        int max=0,length=0;
        for(char c: s.toCharArray()){
            if(map.get(c)==null){
                map.put(c,1);
                length++;
                if(max<=length)
                    max=length;
            }else{
                map.clear();
                map.put(c,1);
                length=1;
            }
        }
        return max;
    }

    static String subStringSearch(String str, String pattern){
        return null;
    }
    static int atoi(String str) {
        // Your code here
        int value = 0;
       // str = str.toLowerCase();
        String s1 = "";boolean flag = false;
        if(str.charAt(0)=='-') {
            s1 = str.substring(1);
            flag=true;
        }
        else
            s1 = str;
        int size = s1.length();
        for(int i=0; i<size; i++) {
            char ch = s1.charAt(i);
            if(!Character.isDigit(ch)&&ch!='-') {

                return -1;
            }
            value = (value << 3) + (value << 1) + (ch - '0');
        }
        if(flag)
            return -value;
        return value;
    }

    public int myAtoi(String s) {
        int value = 0;
        boolean flag=false,flag1=false;
        s=s.strip();
        int size = s.length();
        for(int i=0; i<size; i++) {
            char ch = s.charAt(i);
            if(ch=='-'&&(i+1<size)&&Character.isDigit(s.charAt(i+1)))
                flag = true;
            if(!Character.isDigit(ch)&&!flag1)
                return 0;
          else  if(Character.isDigit(ch)) {
                flag1=true;
                value = (value << 3) + (value << 1) + (ch - '0');
                if(value>=Integer.MAX_VALUE&&!flag)
                    return Integer.MAX_VALUE;
                else if(flag&&value>=Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;


            }

        }
        if(flag)
            return -value;
        return value;

    }
    public static boolean isAnagram(String a,String b)
    {
        if(a.length()!=b.length())
            return false;
        int n = a.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char c: a.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }

        for(char c: b.toCharArray()){
            if(map.get(c)==null)
                return false;
            else{
                map.put(c,map.get(c)-1);
            }
        }

        for(Map.Entry<Character,Integer> m:map.entrySet()){
            if(m.getValue()!=0)
                return false;
        }
        return true;



    }

    public static void main(String[] args) {
        System.out.println(longestSubstrDistinctChars("aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv"));
        System.out.println(longestSubstrDistinctChars("aaa"));
        System.out.println(longestSubstrDistinctChars("deven"));
        System.out.println(longestSubstrDistinctChars("aewergrththy"));
        System.out.println(longestSubString("aewergrththy"));
        System.out.println(atoi("-123"));
        System.out.println(isAnagram("allergy","allergic"));
    }
}
