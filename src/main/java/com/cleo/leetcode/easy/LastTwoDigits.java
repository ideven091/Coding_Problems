package com.cleo.leetcode.easy;

import java.io.IOException;
import java.math.BigInteger;

public class LastTwoDigits {

    public static long lastTwoDigits(long N){
        N = N%300;
      //  System.out.println(N);
        return fib(N)%100;


    }
    public static long fib(long N){
        long a=0,b=1;
        for (int i = 1; i < N; i++) {

                b = a+b;
            a = b -a;

        }
        return b;
    }
    public static long fibV3(long N){
        N = N%300;
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        for (int i = 1; i < N; i++) {
            one = zero.add(one);
            zero = one.subtract(zero);
        }
        one=one.mod(BigInteger.valueOf(100));
        return Long.parseLong(String.valueOf(one));
    }

    public static void main(String[] args) throws IOException {
   //    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(fibV3(804289383));
        fibV3(804289383);
     //   System.out.println(lastTwoDigits(804289383));
        System.out.println(fib(804289383));
       // System.out.println();
      //  System.out.println(lastTwoDigits(121));
    }
}
