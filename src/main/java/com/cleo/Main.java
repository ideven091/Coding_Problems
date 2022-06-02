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
    public static void main(String[] args) {
        System.out.println("Intellij Idea");
    }
}
