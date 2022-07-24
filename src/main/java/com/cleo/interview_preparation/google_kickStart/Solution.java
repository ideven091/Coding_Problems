package com.cleo.interview_preparation.google_kickStart;
import java.util.*;

public class Solution {

    static boolean canFormPalindrome(char[] blocks, int left, int right) {
        boolean isPalindrome = false;

        // TODO: implement logic to determine whether blocks[l]..blocks[r] can form a palindrome
        // NOTE: remember that blocks[] indexes start at 1, so blocks[0] is empty!

        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get number of test cases in input
        int testCaseCount = scanner.nextInt();
        // Iterate through test cases
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            // Get number of blocks & questions for this test case
            int numberOfBlocks = scanner.nextInt();
            int numberOfQuestions = scanner.nextInt();

            // Read consecutive block characters as a single string
            String blockString = scanner.next();
            // Create array of characters for each block, starting with index 1
            char[] blocks = new char[numberOfBlocks + 1];
            for (int i = 0; i < numberOfBlocks; ++i) {
                blocks[i + 1] = blockString.charAt(i);
            }
            int palindromeCount = 0;
            // Iterate through questions for this test case
            for (int i = 0; i < numberOfQuestions; ++i) {
                // Get left-index and right-index (inclusive) for this question
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                // Create a copy of blocks[] array so that canFormPalindrome()
                // can safely modify it without affecting other questions
                char[] blockCopy = Arrays.copyOf(blocks, blocks.length);
                // Increment count if this question's sub-array can form a palindrome
                if (canFormPalindrome(blockCopy, left, right)) {
                    ++palindromeCount;
                }
            }
            // Print results
            System.out.println("Case #" + tc + ": " + palindromeCount);
        }
    }
}

