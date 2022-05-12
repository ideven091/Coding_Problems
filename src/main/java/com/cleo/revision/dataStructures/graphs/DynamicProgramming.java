package com.cleo.revision.dataStructures.graphs;

import java.util.Arrays;

class Fibonacci{
    private int N;

    protected long[] memo;


    public Fibonacci(int n) {
        N = n+1;
        memo = new long[N];
        Arrays.fill(memo,-1);
    }

    public long fib(int n){

        if(memo[n]==-1){
            long res;
            if(n == 0 || n == 1)
                return n;
            else
                res = fib(n-1)+fib(n-2);
            memo[n]=res;
        }
        System.out.println(Arrays.toString(memo));
        return memo[n];

    }

}

public class DynamicProgramming {

    public static void main(String[] args) {
        var fib = new Fibonacci(100);
       System.out.println(fib.fib(100));
    }

}
