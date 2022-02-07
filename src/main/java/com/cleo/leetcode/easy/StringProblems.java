package com.cleo.leetcode.easy;

import java.util.Stack;

public class StringProblems {

    public static String removeConsecutiveDuplicates(String str)
    {
        // Your code here

        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)!=str.charAt(i-1))
                result.append(str.charAt(i));

        }
        return result.toString();
    }
    public static String removePair(String str)
    {
        // your code here
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(str.charAt(i));
            }
            else if(stack.peek()==str.charAt(i))
                stack.pop();
            else
                stack.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "aaabbaaccd";
        System.out.println(removeConsecutiveDuplicates(str));
        System.out.println(removePair(str));
    }
}
