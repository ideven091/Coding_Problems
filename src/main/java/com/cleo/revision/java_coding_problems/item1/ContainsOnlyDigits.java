package com.cleo.revision.java_coding_problems.item1;

public class ContainsOnlyDigits {

    public static boolean contains_digits(String str){
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }

        return true;

    }

    public static boolean containsDigitsV2(String str){

        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n));
    }
    public static boolean containsDigitsV3(String str){
        return str.chars()
                .allMatch(Character::isDigit);
    }

    public static boolean containsDigitsV4(String str){
        return str
                .matches("[0-9]+");
    }

    public static void main(String[] args) {
        String str1 = "1234322342";
        String str2= "234243J423r52";

        System.out.println(contains_digits(str1));
        System.out.println(contains_digits(str2));
        System.out.println(containsDigitsV2(str1));
        System.out.println(containsDigitsV2(str2));
        System.out.println(containsDigitsV3(str1));
        System.out.println(containsDigitsV3(str2));
        System.out.println(containsDigitsV4(str1));
        System.out.println(containsDigitsV4(str2));
    }
}
