package com.cleo.problems.backtracking;

import java.util.Arrays;

public class InsertAtIndex {

    public static void insertAtIndex(int[] arr, int N, int index, int element){
        if(index == N){
            arr[index] = element;
            return;
        }
        int temp = -1;
        int i = index;

        for(i=index;i<N-1;i++){
            if(i == index) {
                temp = arr[i];
                arr[i] = element;
                arr[i+1] = temp;
                i++;
            }else{
               // temp = arr[i];
                arr[i] = arr[i-1];
            }


        }


    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,12,34};
        int[] newArr = new int[arr.length+1];
        int i = 0;
        for(int c: arr){
            newArr[i++] = c;
        }
        insertAtIndex(newArr,arr.length+1,3,234);
        Arrays.stream(newArr).forEach(n -> System.out.print(n + " "));
    }
}
