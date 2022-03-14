package com.cleo.dataStructures.dynamicProgramming;

public class LCSLength {

    /**
     *
     * Non Memoised Version
     */
    public static int lcsLength(String x, String y, int m, int n){
        if(m==0||n==0)
            return 0;
        else if(x.charAt(m-1)==y.charAt(n-1))
            return lcsLength(x,y,m-1,n-1)+1;
        return Math.max(lcsLength(x,y,m-1,n),lcsLength(x,y,m,n-1));
    }

    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";
        System.out.println(lcsLength(X,Y,X.length(),Y.length()));
    }
}
