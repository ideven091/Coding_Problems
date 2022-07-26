package com.cleo.revision.modernJava.ch15;

public class ThreadExample {
    public static int f(int x){
        return x*2;
    }
    public static int g(int x){
        return x*3;
    }

    public static void main(String[] args) throws InterruptedException {
        int x = 1337;
        Result result = new Result();
        var t1 = new Thread(()-> {result.left=f(x);});
        var t2 = new Thread(()->{result.right=g(x);});
        t1.start();
        t2.start();
        t1.join();t2.join();
        System.out.println(result.left + " " + result.right +" " + t1.getId() + " " + t2.getId());
    }

    private static class Result{
        private int left;
        private int right;
    }

}
