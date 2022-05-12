package com.cleo.revision.searching;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemsOnSearching {

    public static int getSquareRoot(int x){
        int index1=-1, index2=-1;
        for (int i = x/2; i >=0 ; i--) {
            if(index2==-1) {
                if (i * i > x)
                    index2 = i;
            }else{
                if(i*i<=x)
                    return i;
            }

        }
        return 0;
    }

    public static int getSquareRootV2(int x){
        int low = 0, high = x;
        int mid = (low+high)/2;
        int answer = -1;
        while(low<=high){
            mid = (low+high)/2;
        //    System.out.println(mid);
            if(mid*mid<x)
                low = mid +1;
            else if(mid*mid==x)
                return mid;
            else {
                high = mid - 1;
                answer = high;
            }
        }
        return answer;

    }
    static int searchInSorted(int[] arr, int N, int K)
    {

        // Your code here
        int low = 0, high = N;
        int mid = (low+high)/2;
        //int answer = -1;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]<K)
                low=mid+1;
            else if(arr[mid] == K)
                return 1;
            else{
                high = mid-1;
            //    answer = high;
            }
        }
        return -1;

    }
    public static int countOnes(int arr[], int N){

        // Your code here
        return Arrays.stream(arr).sum();

    }

    // TODO: 09/01/22  
    static int majorityElement(int[] a, int size)
    {
        // your code here
        Arrays.sort(a);
   //     Arrays.stream(a).forEach(n ->System.out.print(n + " "));
        System.out.println();
        int count = 0, max_count = Integer.MIN_VALUE;
     //   int element = a[0];
        for (int i = 1; i < size; i++) {
            if(a[i] == a[i-1]) {
                count++;
         //       System.out.print(count + " ");
            }
            else{
                if(max_count<count){
                    max_count = count;
            //        System.out.println(max_count);
                }
                count = 1;

            }
          //  System.out.println(max_count);
        }
        if(max_count<count)
            max_count = count;
        if(max_count == 1)
            return -1;
        return max_count;
    }

    static int majorityElementV2(int[] a, int size){
        int count = 0, max_count=0,element=-1;
        Arrays.sort(a);
        //Arrays.stream(a).forEach(System.out::print);
        for (int i = 0; i < size; i++) {
          // System.out.print(max_count+ " ");
            if(i>0&& a[i]==a[i-1]) {
                count++;
                if(max_count<=count) {
                    max_count = count;
                    element = a[i];
                }
            }
           else if(i>0&&a[i]!=a[i-1]) {

               count = 0;
           }
        }
        System.out.println();
        System.out.println(max_count +" " + element);
        if(max_count>size/2)
            return element;
        return -1;
    }

    public static void intersectionOfSortedArrays(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            int element = arr1[i];
            for (int k = j; k < arr2.length; k++) {
                if(element == arr2[k]) {
                    set.add(element);
              //      continue;
                }else if(element>arr2[k]){
                    j = k;
                //    continue;
                }


            }
        }
        set.stream().forEach(n -> System.out.print(n + " "));
    }

    public static void intersection(int[] arr1, int[] arr2, int n, int m){
        int i=0,j=0;
        while(i<n && j < m){
            if(arr1[i]<arr2[j])
                i++;
            else if(arr1[i]>arr2[j])
                j++;
            else{
                System.out.print(arr1[i]+ " ");
                i++;j++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/input.txt")));

        System.out.println(getSquareRootV2(35));
        System.out.println(getSquareRoot(35));
        int[] x = {1,2,3,4,6};
        System.out.println(searchInSorted(x,x.length,5));
        int[] y = {1,3,4,4,4,5,8,4,4,4,4,4,4};
        System.out.println(majorityElement(y,y.length));
        intersectionOfSortedArrays(x,y);
        System.out.println();
        intersection(x,y,x.length,y.length);
        System.out.println();
        System.out.println(majorityElementV2(y,y.length));
        Scanner scanner = new Scanner(new FileInputStream("src/main/resources/input.txt"));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(majorityElementV2(arr,n));
    }
}
