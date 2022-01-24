package com.cleo.revision.multiTasking;

public class TGroups {

    public static void main(String[] args) {
        Reservation res = new Reservation();
        Cancellation cancellation = new Cancellation();

        ThreadGroup tg = new ThreadGroup("First Group");

        Thread t1 = new Thread(tg, res, "First Thread");
        Thread t2 = new Thread(tg, res, "Second Thread");

        ThreadGroup tg1 = new ThreadGroup(tg,"Second");
        Thread t3 = new Thread(tg, cancellation, "third Thread");
        Thread t4 = new Thread(tg, cancellation, "fourth Thread");

        System.out.println("Parent of tg1: " + tg1.getParent());
        tg1.setMaxPriority(7);
        System.out.println("Thread group of t1: " + t1.getThreadGroup());
        System.out.println("Thread group of t3: " + t3.getThreadGroup());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("Active threads " + tg.activeCount());
    }
}

class Reservation extends Thread{

    @Override
    public void run() {
        System.out.println("I am a reservation thread");
    }
}

class Cancellation extends Thread{

    @Override
    public void run() {
        System.out.println("Cancellation");
    }
}