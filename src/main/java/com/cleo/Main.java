package com.cleo;

public class Main {

    public int fib(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else{
            int a = 0,b=1;
            for (int i = 2; i <=n ; i++) {
                b = a+b;
                a = b -a;
            }
            return b;
        }
    }

    //Pattern Matching Usage

    public static int fibV2(int n){
        return switch (n){
            case 0->0;
            case 1->1;
            default -> fibV2(n-1)+fibV2(n-2);
        };
    }

    public static int factorial(int n){
     return n==0?1:n*factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Intellij Idea");
        System.out.println(fibV2(10));
        System.out.println(factorial(10));
    }
}
