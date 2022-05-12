package com.cleo.java_coding_problems.dynamicProgramming;

public class Fibonacci {

    public static int nThFibonacci(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;

        else{
            int a =0;
            int b = 1;
            for(int i=1;i<n;i++){
                b = a + b;
                a = b - a;

            }
            return b;
        }

    }



    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(nThFibonacci(i) + " ");

        }
    }
}
