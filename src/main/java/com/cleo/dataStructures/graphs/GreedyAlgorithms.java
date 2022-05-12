package com.cleo.dataStructures.graphs;

import java.util.Arrays;
import java.util.Comparator;

class CoinChangeProblem{

    public int minimumCoins(int[] arr, int n, int sum){
        Arrays.sort(arr);
        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println();
        int i=0;
        int res=0;
        while(true){
            if(i>=arr.length)
                return -1;
            if(sum==0)
                return res;
            else if(arr[i]<=sum){
                sum -= arr[i];
                res+=1;
                System.out.print(sum + " ");
            }
            else
                i++;
        }




    }

}

class ActivitySelectionProblem{
    private static class Activity{
        int start;
        int finish;

    public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
   private static class ActivityComparator implements Comparator<Activity>{
        @Override
        public int compare(Activity first, Activity second) {
            return first.finish - second.finish;
        }
    }

    /**
     *
     * 2 pointer approach to solve the activity selection problem
     *
     */
    static int maximumActivities(Activity[] arr, int n){

        Arrays.sort(arr, new ActivityComparator());
        int res=1;
        int prev=0;
        //System.out.println(n);
        for (int i = 1; i < n; i++) {
            if(arr[i].start>=arr[prev].finish){
                //   System.out.println("Hi");
                res++;
                prev= i;

            }
        }
        return res;
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        //  System.out.println(n);
        // add your code here
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i]=new Activity(start[i],end[i]);
        }
        return maximumActivities(activities,n);
    }

    public static void main(String[] args) {

        int[] start={5,3};
        int[] end={7,5};

        Activity[] activities = {new Activity(1,3),new Activity(2,4),new Activity(3,5)};
        System.out.println((maximumActivities(activities,activities.length)));
        System.out.println(activitySelection(start,end,2));
    }
}

public class GreedyAlgorithms {

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};

        CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
        System.out.println(coinChangeProblem.minimumCoins(coins,coins.length,6249));

    }
}
