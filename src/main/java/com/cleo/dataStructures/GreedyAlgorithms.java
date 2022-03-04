package com.cleo.dataStructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Activity{
    int start;
    int finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class ActivityComparator implements Comparator<Activity>{
    @Override
    public int compare(Activity first, Activity second) {
        return first.finish - second.finish;
    }
}


class ActivitySelectionProblem{


    /**
     *
     * 2 pointer approach to solve the activity selection problem
     *
     */
    static int maximumActivities(Activity[] arr, int n){

        Arrays.sort(arr, new ActivityComparator());
        int res=1;
        int prev=0;

        for (int i = 1; i < n; i++) {
            if(arr[i].start>=arr[prev].finish){
                res++;
                prev= i;

            }
        }
        return res;
    }

    public static void main(String[] args) {

       Activity[] activities = {new Activity(1,3),new Activity(2,4),new Activity(3,5)};
        System.out.println(maximumActivities(activities,activities.length));
    }
}

public class GreedyAlgorithms {


}
