package com.cleo.revision.dataStructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class OperationOnArrays {

    //Insert at a given index
    public static void insert(int[] arr, int element, int position, int length){
        int answer = arr[position-1];
      //  arr[position-1] = element;
        for (int i = length-2; i >=position; i--) {

            arr[i+1] = arr[i];

        }
        arr[position -1] = element;
        //arr[position-1] = element;

    }

    public static int largestElementArray(int[] arr){
        int max = -1;
        for(int c: arr){
            if(max < c)
                max = c;
        }
        return max;
    }

    public static int secondLargestElement(int[] arr){
        int max = -1;
        int secondMax = -1;
        for(int c: arr){
            if(max < c)
                max = c;
            else if(secondMax < c)
                secondMax = c;
        }
        return secondMax;
    }



    public static void reverse(int[] arr, int length){
        for (int i = 0; i <=length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[length-i-1];
            arr[length-i-1] = temp;
        }
    }

    public static void removeDuplicates(int[] arr){
        int pointer = 0;
        int[] temp = new int[arr.length];
        int j=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]!=arr[i+1]){
                temp[j++]=arr[i];

            }

        }
        temp[j] = arr[arr.length-1];
        for (int i = 0; i <=j; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();

    }
    public static void removeDuplicatesV2(int[] arr){
        Arrays.stream(arr)
                .mapToObj(c->(Integer)c)
                .distinct()
                .forEach(n -> System.out.print(n + " "));
    }
    static BigInteger mul(BigInteger x, BigInteger y){

        // Your code here
        return x.multiply(y);

    }
    public static boolean isSorted(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1])
                return false;
        }

        return true;
    }

    public static int missingNumber(int[] arr, int size) {
        // Your code here
        Arrays.sort(arr);
        int smallest = 1, minimum_positive = -1;
        //  Arrays.stream(arr).forEach(n ->System.out.print(n + " "));
        //    System.out.println();
        int i = 0;
        for (; i < size; i++) {
            if(arr[i]>0){
                if(smallest < arr[i])
                    return smallest;
                else if(smallest == arr[i])
                    smallest+=1;
            }
        }
        if(i == size){
            if(arr[i-1]>0)
                return smallest;
        }
        return -1;

    }
   public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here





    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[]{1,2,3,5,10, 0};
        insert(arr,100,2,arr.length);
        System.out.println();
        System.out.println(largestElementArray(arr));
        System.out.println(secondLargestElement(arr));
        System.out.println(isSorted(arr));
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

        System.out.println(isSorted(arr));
        removeDuplicates(arr);
        System.out.println("Removing Duplicates");
        removeDuplicatesV2(arr);
        System.out.println();
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();
        reverse(arr,arr.length);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));

        int[] arr1 = {0,1};
        System.out.println(isSorted(arr1));
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        int[] arr2 = {1,2,3,4,5};

        System.out.println("Missing Number: "+missingNumber(arr2,arr2.length));

     //   System.out.println("Inserting at index 2");
      //  Arrays.stream(arr2).forEach(n -> System.out.print(n + " "));
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0,1);
        integers.add(1,2);
        integers.add(2,3);
        integers.add(3,4);
        integers.add(4,5);



        reverseInGroups(integers,integers.size(),3);
        System.out.println("Reversed in groups");
        integers.forEach(System.out::print);
        System.out.println();

    }
}
