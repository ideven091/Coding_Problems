package com.cleo.codeChef.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lis(String s){
        int[] T = new int[s.length()];
        T[0]=1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(j)>s.charAt(i))
                    T[j]=1+T[i];
                else
                    T[j]=Math.max(T[i-1],T[j]);
            }
        }
        return Math.max(Arrays.stream(T).max().getAsInt(), 0);
    }
    
    public static int lisV2(String s){
        int[] L = new int[s.length()];
        int max=0;
        for (int j = 0; j < s.length(); j++) {
            L[j]=1;
            for (int i = 0; i < j; i++) {
                if(s.charAt(i)<s.charAt(j)&&(L[j]<1+L[i])) {
                    L[j] = 1 + L[i];
                    if(max<=L[j])
                        max=L[j];
                }

            }
        }
       return max;
    }
    static int longestSubsequence(int size, int[] a)
    {
        // code here
        int[] L = new int[size];
        int max = 0;
        for (int j = 0; j < size; j++) {
            L[j]=1;
            for (int i = 0; i < j; i++) {
                if((a[i]<a[j])&&(L[j]<1+L[i])) {
                    L[j] = 1 + L[i];
                    if(max<L[j])
                        max=L[j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "123536";
        System.out.println(lis(s));
        System.out.println(lisV2(s));
        int[] A ={0,8,4,12,2,10,6,14,1,9,5,
            13,3,11,7,15};
        System.out.println(longestSubsequence(A.length,A));
    }
}
