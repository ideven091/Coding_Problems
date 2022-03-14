package com.cleo.dataStructures.dynamicProgramming;

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

public class DynamicProgrammingProblems {


}
