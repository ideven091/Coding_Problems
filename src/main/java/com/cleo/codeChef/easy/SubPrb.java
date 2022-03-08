package com.cleo.codeChef.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SubPrb {

    public static void sumOfSubArrays( int length){
        if(length==1) {
            System.out.println(1);
            return;
        }
        int sum = (length*(length+1))/2;
        int[] factors = new int[sum];
        int l=0;
        for (int i = 1; i <=length ; i++) {
            sum=i*(i+1)/2;
            System.out.println(sum+" ");
            if(sum%i==0)
                System.out.print(sum+ " ");
        }
        System.out.println();
        //return factors;
    }

    public static void main(String[] args) throws Exception{
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(reader.readLine());
            while (T-- > 0) {
                int N = Integer.parseInt(reader.readLine());
                sumOfSubArrays(N);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
