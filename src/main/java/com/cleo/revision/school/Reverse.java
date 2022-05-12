package com.cleo.revision.school;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reverse {

    public static int reverse(int n){
        if(n <10)
            return n;
        else{
            int a = 1;
            while(a*10<n){
                a*=10;
            }
         //   System.out.print(n + " ");
            return reverse(n/10)+(n%10)*a;
        }
    }

    public static void main(String[] args) throws Exception{
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(reader.readLine());
            while(T-->0){
                int value = Integer.parseInt(reader.readLine());
                System.out.println(reverse(value));
            }
        }catch (Exception e){
            return;
        }
    }

}
