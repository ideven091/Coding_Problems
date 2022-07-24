package com.cleo.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P322 {
    public int coinChange(int[] coins, int total) {

        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;
        for(int i=1; i <= total; i++){
            T[i] = Integer.MAX_VALUE-1;
            R[i] = -1;
        }
        for(int j=0; j < coins.length; j++){
            for(int i=1; i <= total; i++){
                if(i >= coins[j]){
                    if (T[i - coins[j]] + 1 < T[i]) {
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                    }
                }
            }
        }
        if(T[total]+1>=Integer.MAX_VALUE)
            return -1;
      //  printCoinCombination(R, coins);
        return T[total];

    }
    public int coinChangeOptimised(int[] coins, int amount) {
        if(coins == null || coins.length == 0|| amount <= 0){
            return 0;
        }
        int max_val = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max_val);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == max_val){
            return -1;
        }else{
            return dp[amount];
        }
    }
    public int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {

        //if total is 0 then there is nothing to do. return 0.
        if ( total == 0 ) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if ( map.containsKey(total) ) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for ( int i=0; i < coins.length; i++ ) {
            //if value of coin is greater than total we are looking for just continue.
            if( coins[i] > total ) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(total - coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if( val < min ) {
                min = val;
            }
        }

        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
        min =  (min >= Integer.MAX_VALUE ? -1 : min);

        //memoize the minimum for current total.
        map.put(total, min);

        return min;
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new P322().coinChange(coins,23));
        Map<Integer,Integer> map = new HashMap<>();
        P322 p = new P322();
        System.out.println(p.minimumCoinTopDown(3,coins,map));
    }

}
