package com.cleo.revision.backtracking;

import java.util.Arrays;

public class ArraySum {

    public static int median(int[] arr, int N){
        Arrays.sort(arr);
        if(N%2==0) {
            System.out.println(arr[N/2]);
            return arr[N / 2];
        }
        else{
            System.out.println(arr[(N-1)/2] + " " + arr[(N+1)/2]);
            return (arr[(N-1)/2]+arr[(N+1)/2])/2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,19,24};
        System.out.println(median(arr,arr.length));
    }
}
