package com.cleo.revision.Hackathon.recursion;

public class Recursive {

    static int powerOfTwo(int i){
        if(i == 0)
            return 1;
        else{
            var power = 2*powerOfTwo(i-1);
            return power;
        }
    }

    static int fib(int n){
        if(n < 2)
            return n;
        else{
            return fib(n-1) + fib(n-2);
        }
    }

    static int gcd(int a, int b){
        if(b == 0)
            return a;
        else
            return gcd(b,a%b);
    }

    public static int factorial(int n){
        if(n == 0)
            return 1;
        else return n*factorial(n-1);
    }

    public static int sumOfDigits(int n){
        if(n == 0)
            return 0;
        else{
            return sumOfDigits(n/10)+n%10;
        }
    }

    public static int power(int number, int power){
        if(power <= 1)
            return number;
        else{
            return number*power(number,power -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(powerOfTwo(5));
        System.out.println(fib(10));
        System.out.println(gcd(10,15));
        System.out.println(factorial(5));
        System.out.println(sumOfDigits(123));

        System.out.println(power(3,2));
    }
}
