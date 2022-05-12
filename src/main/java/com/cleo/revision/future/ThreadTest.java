package com.cleo.revision.future;

import java.util.Arrays;

public class ThreadTest {

    public static void main(String[] args) {
        var bank = new Bank(4,100000);
        Runnable task1 = () -> {
            try{
                for (int i = 0; i < 100; i++) {
                    double amount = 1000*Math.random();
                    bank.transfer(0,1,amount);
                    Thread.sleep((int)(10*Math.random()));

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            try{
                for (int i = 0; i < 100; i++) {
                    double amount = 1000*Math.random();
                    bank.transfer(2,3,amount);
                    Thread.sleep((int)(10*Math.random()));

                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();

    }
}

class Bank{
    private final double[] accounts;

    public Bank(int n,double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts,initialBalance);

    }
    public void transfer(int from, int to, double amount){
        if(accounts[from]<amount)
            return;
        System.out.print(Thread.currentThread());
        accounts[from]-=amount;
        accounts[to]+=amount;
        double sum = Arrays.stream(accounts).sum();
        System.out.println("Final State: " + accounts[from] + " " + accounts[to]);
        System.out.println("Total balance left in account: " + sum);
    }
}
