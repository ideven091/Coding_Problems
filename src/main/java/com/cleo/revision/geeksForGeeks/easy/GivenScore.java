package com.cleo.revision.geeksForGeeks.easy;
// { Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();

            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        long[] dp = new long[(int)n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        int val1 = 3, val2 = 5, val3 = 10;
        // Add your code here.


        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = i+1; j < n+1; j++) {

            }
        }

        return dp[n];
    }
}
public class GivenScore {
}
