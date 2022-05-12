package com.cleo.revision.geeksForGeeks.hashing;


import java.util.*;

public class ProblemsOnHashing {

    static long floorSqrt(long x)
    {
        // Your code here
        long n = x/2;
        long low = 0, high = x;
        long mid = (low+high)/2;
        while(low <= high){
            mid = low + (high - low)/2;
            if(mid*mid<x)
                low+=1;
            else if(mid*mid==x)
                return mid;
            else{
                high = mid -1;
                low = high;

            }
        }
        return mid;
    }
    public static int sumExists(int arr[], int N, int sum) {
        // Your code here, Geeks
        var list = new Stack<Integer>();
        int a1 = -1, a2 = -1;
        list.add(arr[0]);
        for (int c:arr) {
            if((sum-c)==list.peek()){
                return 1;
            }
            list.add(c);

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(24));
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(sumExists(arr,arr.length,100));
    }
}
