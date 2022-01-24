package com.cleo.revision.recursion;

public class Main {


    public static int gcd(int a, int b){
        if(b== 0)
            return a;
        else{
            return gcd(b,a%b);
        }
    }

    public static int binarySum(String s, int start, int stop){
        if(start >= stop){
            return 0;
        }else if(start == stop -1){
            System.out.println(s.charAt(start));

            return s.charAt(start);
        }else{
            int mid = (start + stop)/2;
            return binarySum(s,start,mid) + binarySum(s,mid,stop);
        }
    }

    public static void main(String[] args) {
	// write your code here

        System.out.println(gcd(24,36));
        System.out.println(binarySum("1234",0,4));


    }
}
