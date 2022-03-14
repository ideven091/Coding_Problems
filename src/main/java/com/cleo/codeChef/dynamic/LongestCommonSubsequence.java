package com.cleo.codeChef.dynamic;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {

    public static int lcsLength(String x, String y, int m, int n, Map<String, Integer> lookup){
        if(m==0||n==0)
            return 0;
        String key = m + "|" + n;
        if(lookup.get(key)==null){
            if(x.charAt(m-1)==y.charAt(n-1))
                lookup.put(key,1+lcsLength(x,y,m-1,n-1,lookup));
            else
                lookup.put(key,Math.max(lcsLength(x,y,m-1,n,lookup),lcsLength(x,y,m,n-1,lookup)));
        }
        return lookup.get(key);

    }

    public static void main(String[] args) {
        String a = "DevenKalra";
        String b = "DvnJra";
        Map<String,Integer> map = new HashMap<>();
        System.out.println(lcsLength(a,b,a.length(),b.length(),map));
    }
}
