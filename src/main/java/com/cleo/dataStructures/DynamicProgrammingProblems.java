package com.cleo.dataStructures;

import java.util.Arrays;

class NthFibonacciNumber{
    private static final int N = 10;
    private static int[] memo =new int[N+1];

    public NthFibonacciNumber(){
        Arrays.fill(memo,-1);
     //   System.out.println(Arrays.toString(memo));
    }
    public static int fib(int n){
        if(memo[n]==-1){
            int res;
            if(n==0||n==1)
                return n;
            res = fib(n-1)+fib(n-2);
            memo[n]=res;
        }
        return memo[n];
    }

    public static void main(String[] args) {
        NthFibonacciNumber fib1= new NthFibonacciNumber();
        System.out.println(fib(N));
        System.out.println(Arrays.toString(memo));
    }
}

class LongestCommonSubsequence{

    public static int lcs(String X, String Y, int N, int M){
        if(N==0||M==0)
            return 0;
        else if(X.charAt(N-1)==Y.charAt(M-1))
            return 1+lcs(X,Y,N-1,M-1);
        else
            return Math.max(lcs(X,Y,N-1,M),lcs(X,Y,N,M-1));
    }

    public static void main(String[] args) {
        String a = "ABCDEFEBG";
        String b = "BDAFE";
        System.out.println(lcs(a,b,a.length(),b.length()));
    }

}

public class DynamicProgrammingProblems {


}
