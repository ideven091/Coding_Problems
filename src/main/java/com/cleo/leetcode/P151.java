package com.cleo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class P151 {
    public static String reverseWords(String s) {
        s = s.toLowerCase();
        s = s.stripLeading();


        var list = s.split(" ");

        StringBuilder answer = new StringBuilder();
        System.out.println(Arrays.toString(list));
        int n = list.length;
        for (int i = n-1; i >0 ; i--) {
            if(list[i].length()>=1) {
                answer.append(list[ i ]);
                answer.append(" ");
            }
        }
        if(list[0].length()>=1)
            answer.append(list[0]);
        return answer.toString();

    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords("aaa    i  have   a car    "));
        System.out.println(reverseWords(s));
        System.out.println(reverseWords(" "));
    }
}
