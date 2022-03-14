package com.cleo.revision.java_coding_problems.dynamicProgramming;

public class LIS {


    /**
     *
     * @param a Given a sequence of integers
     * @return the length of the longest increasing subsequence
     * To find the length of sequence ending at ith character, we find the length which includes the ith character
     * L(i) = L(i-1) + max(longest(i)+1,longest(i))
     */
    public static int longest_increasing_subsequence(int[] a, int n){
        if(n == 0)
            return 0;
        else{
            //if(longest_increasing_subsequence(a,n-1)+longest_increasing_subsequence(a,n))

        }
        return -1;
    }
}
