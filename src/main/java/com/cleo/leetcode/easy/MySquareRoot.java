package com.cleo.leetcode.easy;

public class MySquareRoot {

    public static int mySqrt(int x) {
        if(x==0)
            return 0;
        if(x==1)
            return 1;
        if(x==2)
            return 1;
        int temp = 0,answer=1,i=2,j=2;
        for (i = 1; i < x; i++) {
            answer=i*i;
            temp = (i+1)*(i+1);
            if(temp<0){
                j = i;
                break;
            }
            if(answer==x)
                return i;
            if(temp==x)
                return (i+1);
            if(temp>x)
                return i;
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt((int) Math.pow(2,31)-1));
        int s = (int) Math.pow(2,31)-1;
        System.out.println(s);
    }
}
