package com.cleo.revision.recursion;

class Reserve implements Runnable{

    private int available = 1, wanted;

    public Reserve(int i) {

        wanted = i;
    }

    @Override
    public void run() {

        synchronized (this) {
            System.out.println("Available berths: " + available);
            if (available >= wanted) {
                String name = Thread.currentThread().getName() + " " + Thread.activeCount() + Thread.MAX_PRIORITY;

                System.out.println(wanted + " Berths reserved for " + name);
                try {
                    Thread.sleep(1500);
                    available -= wanted;
                    System.out.println("I want a JOB SOON " + Thread.activeCount());
                } catch (InterruptedException interruptedException) {
                    System.out.println("Sorry " + interruptedException.getMessage() + " " + name);
                }finally {
                    System.out.println(Thread.currentThread());
                }
            } else {
                System.out.println("Sorry piss off");
            }
        }
    }
}


public class Unsafe {

    public static void main(String[] args) {
        Reserve obj = new Reserve(1);
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        t1.setName("Muttley");
        t2.setName("Intellij Idea");

        t1.start();
        t2.start();
    }
}
