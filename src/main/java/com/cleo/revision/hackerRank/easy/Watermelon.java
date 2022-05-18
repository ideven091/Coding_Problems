package com.cleo.revision.hackerRank.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Watermelon {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if(n==2){
            System.out.println("NO");

        }
        else if(n%2==0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }


}
