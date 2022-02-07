package com.cleo.dataStructures.strings;
import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    private static final String numbers = "0123456789";
    private static final String lower_case = "abcdefghijklmnopqrstuvwxyz";
    private static final String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String special_characters = "!@#$%^&*()-+";

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        String result = "";
        stack.push(s.charAt(0));
      //  System.out.println(stack);
        //result+=s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
           // char temp = stack.peek();
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
      //          System.out.println(stack);
            }
          else  if (stack.peek()!=s.charAt(i)) {
                stack.push(s.charAt(i));
                //result+=s.charAt(i)
            } else if(stack.peek()==s.charAt(i)) {

                stack.pop();

            }
    //        System.out.println(stack);
        }
        if(stack.isEmpty()){
            return "Empty String";
        }else {
            for (char c : stack) {
                result += c;
            }
        }


        return result;
    }
    /**
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */
    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong

        boolean numberPresent = false, upperCasePresent=false, lowerCasePresent=false,specialCharacterPresent = false;
        int count = 0;
        for(char c: password.toCharArray()){
            if(Character.isDigit(c)){
                numberPresent=true;
            }
            else if(Character.isUpperCase(c))
                upperCasePresent=true;
            else if(Character.isLowerCase(c))
                lowerCasePresent = true;
            else
                specialCharacterPresent = true;
        }
        if(!numberPresent)
            count+=1;
        if(!lowerCasePresent)
            count+=1;
        if(!upperCasePresent)
            count+=1;
        if(!specialCharacterPresent)
            count+=1;
        if(n<6){
            count+=(6-n);
        }

        return count;


    }

}

class SuperReducedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
