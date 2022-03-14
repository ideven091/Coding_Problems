package com.cleo.dataStructures;

class MaximumNumberAfterKSwaps{

    public String findMaximumNum(String s, int k){
        max = Long.parseLong(s);
        f(s,k);

        return Long.toString(max);
    }

    long max=Long.MIN_VALUE;

    public void f(String s, int k) {
        if (k == 0)
            return;
        if (s.compareTo(String.valueOf(Long.MAX_VALUE)) < 0) {
            //   System.out.println(Long.parseLong(s));
            max = Math.max(Long.parseLong(s), max);
            //System.out.println(max);
        }


        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {


                if (s.charAt(i) < s.charAt(j)) {

                    s = new String(swap(s, i, j));
                  //  System.out.println(s);
                    f(s, k - 1);
                    s = new String(swap(s, i, j));
                }
            }
        }
    }



    public static char[] swap(String str, int i, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
        return ch;
    }

    public static void main(String[] args) {
        String str = "3435335";
        System.out.println(new MaximumNumberAfterKSwaps().findMaximumNum(str,3));
    }
}
public class ProblemsOnBackTracking {

    public static void main(String[] args) {

    }
}
