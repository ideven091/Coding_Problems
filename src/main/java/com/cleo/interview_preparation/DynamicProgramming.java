package com.cleo.interview_preparation;

import java.util.Arrays;

class EditDistance {

    //Max speed
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];
        for(int[] row : dp)
            java.util.Arrays.fill(row,-1);

        return f(n,m,word1,word2,dp);
    }

    public int f(int i,int j,String word1, String word2,int dp[][] ){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1)return dp[i][j];

        if(word1.charAt(i-1)==word2.charAt(j-1))
            return dp[i][j]= f(i-1,j-1,word1,word2,dp);

        int insert = 1+f(i,j-1,word1,word2,dp);
        int delete = 1+f(i-1,j,word1,word2,dp);
        int replace = 1 + f(i-1,j-1,word1,word2,dp);

        return  dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }
    //Min Memory Usage
    public int minDistanceV2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;

                else if (j == 0)
                    dp[i][j] = i;

                else if (word1.charAt(i - 1)
                        == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = 1
                            + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j],
                                    dp[i - 1]
                                            [j - 1]));
            }
        }
        return dp[m][n];
    }
}

public class DynamicProgramming {

    int sum = 0;

    //Recurrence Relation=
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int paths=0;
        if(m==1&&n==1)
            return 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0)
                    dp[i][j]=j;
                else if(j==0)
                    dp[i][j]=i;
                else{
                    dp[i][j]=1+Math.max(dp[i-1][j],dp[i][j-1]);
                    paths+=1;

                }



            }
        }
        paths+=dp[m-1][n-1];
        System.out.println(paths);
        Arrays.stream(dp).forEach(n1 -> System.out.println(Arrays.toString(n1)));
        return dp[m-1][n-1];



    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1)return cost[0];
        int[] dp = new int[cost.length];
        dp[0]=cost[0];
        dp[1]=Math.min(cost[0],cost[1]);
        for (int i = 2; i < n; i++) {
            dp[i]=Math.min(cost[i]+dp[i-1],cost[i]+dp[i-2]);



        }
       // System.out.println(Arrays.toString(dp));
        return Math.min(dp[n-1],dp[n-2]);

    }

    public int fib(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else{
            int a =0,b=1;
            for (int i = 2; i <=n; i++) {
                b = a+b;
                a = b -a;
            }
            return b;
        }

    }
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
     //   int sum = 2;
      //  int a=0,b=1,c=2,d=0;
        int[] dp = new int[n+1];
        dp[0]=0;dp[1]=1;dp[2]=1;
        for (int i = 3; i <= n; i++) {

            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];


        }
      //  System.out.println(Arrays.toString(dp));
        return dp[n];

    }
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        int n = nums.length,j=1;
        int[] dp = new int[n+1];
        boolean flag = false;
        System.out.println(Arrays.toString(nums));
        dp[0]=nums[n-1];
        for (int i = n-2; i >=0 ; i--) {

            for (int k = 0; k <= j; k++) {
                flag= (nums[ i ] - 1) != dp[ k ] && (nums[ i ] + 1) != dp[ k ];

            }
            if(flag){
                dp[j]=dp[j-1]+nums[i];
                j+=1;
                flag=false;
            }else{
                dp[j]=dp[j-1];
                j+=1;
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[n];

    }

    public int minPathSum(int[][] cost) {
        int[][] T = new int[ cost.length][cost[0].length];
        int sum=0,max_sum=0;

        int M = cost.length,N = cost[0].length;
        // fill the matrix in a bottom-up manner
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                T[i][j] = cost[i][j];

                // fill the first row (there is only one way to reach any cell
                // in the first row from its adjacent left cell)
                if (i == 0 && j > 0) {
                    T[0][j] += T[0][j - 1];
                }

                // fill the first column (there is only one way to reach any cell
                // in the first column from its adjacent top cell)
                else if (j == 0 && i > 0) {
                    T[i][0] += T[i - 1][0];
                }

                // fill the rest with the matrix (there are two ways to reach any
                // cell in the rest of the matrix, from its adjacent
                // left cell or adjacent top cell)
                else if (i > 0 && j > 0) {
                    T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        return T[M-1][N-1];

    }

    public static void main(String[] args) {

        String word1="horse",word2="horse";
        EditDistance distance = new EditDistance();
        System.out.println(distance.minDistance(word1,word2));
        System.out.println(distance.minDistanceV2(word1,word2));
        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.uniquePaths(3,7));
        int[] cost = {10,8,6,6,20};
        int[] cost1 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(dp.minCostClimbingStairs(cost));
        System.out.println(dp.minCostClimbingStairs(cost1));
        System.out.println(dp.fib(10));
        System.out.println(dp.tribonacci(25));
        int[] nums ={2,2,3,3,3,4};
        System.out.println(dp.deleteAndEarn(nums));
    }
}
