package com.cleo.revision.school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigits {

    public static int sum(int n){
        if(n==0)
            return 0;
        else
            return sum(n/10)+n%10;
    }

    public static void main(String[] args) throws IOException {
        try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        while(T-->=0){
            int n = Integer.parseInt(reader.readLine());
            System.out.println(sum(n));

        }}catch (Exception e){
            return;
        }
    }
}
