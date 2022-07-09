package com.cleo.interview_preparation.sde_sheet;

import java.util.*;

public class ArrayProblems {

    public static ArrayList<Integer> duplicates(int[] arr, int n) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int c: arr){
            map.merge(c, 1, Integer::sum);
        }
        for(var c: map.entrySet()){
            if(c.getValue()>1)
                answer.add(c.getKey());
        }
        if(answer.size()==0) {
            answer.add(-1);
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    // TODO: 09/07/22  
    static long inversionCount(long[] arr, long N) {
        // Your Code Here
        long count = 0;
        return 0;
    }
    public static boolean containsElement(int[] arr, int element){
        Arrays.sort(arr);
        return Arrays.binarySearch(arr,element)>=0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,2};
        System.out.println(duplicates(arr,arr.length));
        System.out.println(containsElement(arr,5));
    }
}
