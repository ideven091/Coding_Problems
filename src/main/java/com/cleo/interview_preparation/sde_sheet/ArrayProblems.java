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
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int n = c.size();
        int jumps = 0;
        if(n==2)
            return 1;
        int i=0;
        while( i<n-1){
            if(c.get(i+2)>=n)
                return jumps+1;
            if(c.get(i)==0){

                if(c.get(i+2)==0){
                    i+=2;
                    jumps+=1;
                }
                else if(c.get(i+1)==0) {
                    jumps += 1;i+=1;
                }



            }
        }
        //    System.out.println("Hola");
        return jumps;
    }
    public static long repeatedString(String s, long n) {
        // Write your code here
        int length = s.length();
        long count = s.chars().filter(w ->w=='a').count();
        //System.out.println(count);
        //System.out.println(length);
        if(n/length==0)
            return count*(n/length);
        else{
            long remainder = n%length;
            count=count*(n/length);
            count+=s.chars().filter(w->w=='a').limit(remainder).count();
            return count;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,2};
        System.out.println(duplicates(arr,arr.length));
        System.out.println(containsElement(arr,5));
        List<Integer> c = List.of(0,0,1,0,0,1,0);
        List<Integer> c1 = List.of(0, 0, 0, 0, 1,0,0, 0);
        System.out.println(jumpingOnClouds(c));
        System.out.println(jumpingOnClouds(c1));
        String s  = "abcac";
        System.out.println(repeatedString(s,11));
    }
}
