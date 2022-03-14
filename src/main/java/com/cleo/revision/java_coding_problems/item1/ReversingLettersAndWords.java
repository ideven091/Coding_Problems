package com.cleo.revision.java_coding_problems.item1;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReversingLettersAndWords {

    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");
    public static String reverseWords(String str){

        var words = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for(var word: words){
            var reversedWord = new StringBuilder();
            for (int i = word.length() -1; i >=0; i--) {
                reversedWord.append(word.charAt(i));
            }
            stringBuilder.append(reversedWord).append(WHITESPACE);
        }
        return stringBuilder.toString();
    }

    public static String reverseWordsV2(String str){
        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));

    }

    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        String str = "Jack is a good boy";
        var time1 = System.nanoTime();
        String reversed = reverseWords(str);
        var time2 = System.nanoTime();
        System.out.println("Reversed String "+ reversed + " took time " + (time2 - time1));
        time2 = System.nanoTime();
        String reversedV2 = reverseWordsV2(str);
        var time3 = System.nanoTime();
        System.out.println("Reversed String "+ reversedV2 + " took time " + (time3 - time2));
        String reversedString = reverseString(str);

        System.out.println(reversedString);



    }

}
