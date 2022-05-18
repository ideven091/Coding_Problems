package com.cleo.revision.hackerRank.dynamic;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(char[] arr1, char[] arr2, int n, int m){

     if(n == 0 || m == 0)
         return 0;
     else if(arr1[n-1]==arr2[m-1]){
         return 1+longestCommonSubsequence(arr1,arr2,n-1,m-1);
     }else{
         return Math.max(longestCommonSubsequence(arr1,arr2,n-1,m),longestCommonSubsequence(arr1,arr2,n,m-1));
     }

    }

    public static void main(String[] args) {
        char[] a1 = {'D','E','V','E','N'};
        char[] a2 =  {'D','E','V','I','N','A'};
        System.out.println(longestCommonSubsequence(a1,a2,a1.length,a2.length));
    }
}
