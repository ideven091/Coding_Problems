package com.cleo.revision.Hackathon.recursion;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReversingLettersAndWords {

    private static final String WHITESPACE = " ";

    public static String reverseWords(String str){

        String[] words= str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for(String word: words){
            StringBuilder reversedWord = new StringBuilder();
            for (int i = word.length()-1; i>=0; i--) {
                reversedWord.append(word.charAt(i));
            }
            reversedString.append(reversedWord).append(WHITESPACE);
        }
        return reversedString.toString();
    }

    private static final Pattern PATTERN = Pattern.compile(" +");

    /**
     * @author Deven
     * @param str Given String
     * @return Functionally reversing each word in the line
     */



    public static String functionallyReverseWords(String str){

        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public static void main(String[] args) {
        String words = "Hi There this seems a cute place";
        System.out.println(reverseWords(words));
        System.out.println(functionallyReverseWords(words));
        System.out.println(reverse(words));
    }
}
