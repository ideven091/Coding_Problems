package com.cleo.codeChef.dynamic;

/**
 * Given an array of N integers arr[] where each element represents the max number of
 * steps that can be made forward from that element.
 * Find the minimum number of jumps to reach the end of the array
 * (starting from the first element).
 * If an element is 0, then you cannot move through that element.
 * Note: Return -1 if you can't reach the end of the array.
 */

public class MinimumNumberOfJumps {
    static boolean isSafe(int curr_position, int position, int[] arr){
        return arr[position] != 0 && curr_position <= arr.length - 1;
    }


    static int minJumps(int[] arr) {
        // your code here
        //      int[] T = new int[arr.length];
        int curr_position = 0;
        int jumps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isSafe(curr_position, i, arr)) {
                     curr_position += arr[i];

                        if(curr_position>=arr.length)
                            return jumps;
                jumps += 1;

                }else{
                return -1;
            }


        }
            return jumps;

    }

    public static void main(String[] args) {
        int N = 11;
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr2 = {1, 4, 3, 2, 6, 7};
        int[] arr3={0,1,1};
        int[] arr4={2,-1,2};
        int[] arr5={2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println(minJumps(arr));
        System.out.println(minJumps(arr2));
        System.out.println(minJumps(arr3));
        System.out.println(minJumps(arr4));
        System.out.println(minJumps(arr5));

    }
}
