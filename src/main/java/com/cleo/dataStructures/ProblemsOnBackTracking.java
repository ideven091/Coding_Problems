package com.cleo.dataStructures;

public class ProblemsOnBackTracking {
    public String findMaximumNum(String s, int k){
        max = Long.parseLong(s);
        f(s,k);

        return Long.toString(max);
    }

    long max;

    public void f(String s, int k){
        if(k == 0)
            return;
        if(s.compareTo(String.valueOf(Long.MAX_VALUE))<0) {
          //  System.out.println(Long.parseLong(s));
            max = Math.max(Long.parseLong(s), max);
         //   System.out.println(max);
        }


        int n = s.length();

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)>s.charAt(i)){

                    s = swap(s,i,j);
                    f(s,k-1);
                    s = swap(s,i,j);
                }
            }
        }
    }

    public String swap(String s, int i,int j){
        char[] c = s.toCharArray();

        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;

        return String.valueOf(c);
    }
    public static void main(String[] args) {
        String str = "4867504573120052493";
        System.out.println(new ProblemsOnBackTracking().findMaximumNum(str,3));
    }
}
