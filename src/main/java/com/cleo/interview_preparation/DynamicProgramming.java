package com.cleo.interview_preparation;

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


    public static void main(String[] args) {

        String word1="horse",word2="horse";
        EditDistance distance = new EditDistance();
        System.out.println(distance.minDistance(word1,word2));
        System.out.println(distance.minDistanceV2(word1,word2));
    }
}
