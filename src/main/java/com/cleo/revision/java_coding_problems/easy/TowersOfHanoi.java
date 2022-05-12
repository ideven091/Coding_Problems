package com.cleo.revision.java_coding_problems.easy;

public class TowersOfHanoi {

    private static long count = 0;
    public static long towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg){
        if(n == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to Peg " + toPeg);
            return ++count;
        }
        count++;
        towersOfHanoi(n -1, fromPeg, auxPeg, toPeg);

        System.out.println("Move disk " + n + " from " + fromPeg + " to " + toPeg);
        count++;
        towersOfHanoi(n -1, auxPeg, toPeg, fromPeg);

        return ++count;
    }

    public static void main(String[] args) {
        System.out.println(towersOfHanoi(3,'A','B','C'));
    }
}
