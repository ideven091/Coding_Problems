package com.cleo.revision.hackerRank.medium;


import java.io.*;
import java.util.stream.*;
        import static java.util.stream.Collectors.joining;

class Result {

    public static boolean isPalindrome(String s){
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;
        }
        return true;
    }

    /**
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     * abcb-> Remove 'a' at index 0-> bcb Palindrome
     */



    public static int palindromeIndex(String s) {
        // Write your code here
       // Stack<Character> palindromic = new Stack<>();
        //palindromic.push(s.charAt(0));
        StringBuilder palindrome=new StringBuilder("");
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            palindrome.append(s.charAt(i));
            System.out.println(palindrome);
            if(palindrome.length()>1)
                if(isPalindrome(palindrome.toString())){
                    index = i;
                }
            }


        System.out.println(palindrome);
        System.out.println(isPalindrome(palindrome.toString()));



        return index;



    }

}

public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
