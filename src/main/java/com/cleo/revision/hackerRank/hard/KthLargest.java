package com.cleo.revision.hackerRank.hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class KthLargest {
   private static int[] arr;
    private static  List<Integer> temp =new ArrayList<>();

    public static void  kthLargest(int query, int k){

      //  System.out.println();

    }
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n, q;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        q = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int query, k;
        while(q-->0){
            query = in.nextInt();
            k = in.nextInt();
            kthLargest(query, k);

        }
    }
}
