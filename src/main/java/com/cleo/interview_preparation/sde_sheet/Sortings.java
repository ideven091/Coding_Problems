package com.cleo.interview_preparation.sde_sheet;

import java.util.Arrays;

class HeapSort{

    public static int count=0;
    public static void heapSort(int[] arr){
        int n = arr.length;
        buildHeap(arr,n);
        while(n>1){
            swap(arr,0,n-1);
          //  System.out.println(Arrays.toString(arr));

            heapify(arr,--n,0);
        }
    }
    private static void buildHeap(int[] arr, int n){
        for (int i = arr.length/2; i >=0 ; i--) {
            heapify(arr,n,i);
        }
    }
    private static void heapify(int[] arr, int n, int i){
        int left = i*2+1;
        int right = i*2+2;

        int greater;
        if(left<n && arr[i]<arr[left]){
            greater=left;
        }else
            greater=i;
        if(right<n && arr[right] > arr[greater])
            greater=right;
        if(greater!=i) {
            count++;
            swap(arr, i, greater);
            heapify(arr,n,greater);
        }
    }
    public static void swap(int[] arr, int i, int greater){
        int temp=arr[i];
        arr[i]=arr[greater];
        arr[greater]=temp;
    }
}

public class Sortings {

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    //temp = arr[j];

                }
            }
        }

    }
    public static void merge(int[] arr, int low, int high){
        int mid = (low+high)/2;


    }

    public static void mergeSort(int[] arr){
        int low=0;
        int high=arr.length-1;
        int mid = (low+high)/2;
        merge(arr,low,mid);
        merge(arr,mid,high);
        merge(arr,0,high);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4};
       // insertionSort(arr);
        System.out.println(Arrays.toString(arr));
        HeapSort.heapSort(arr);
        System.out.println(HeapSort.count);
        System.out.println(Arrays.toString(arr));

    }
}
