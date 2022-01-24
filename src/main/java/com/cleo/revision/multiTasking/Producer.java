package com.cleo.revision.multiTasking;

class Communicate{
    public static void main(String[] args) {
        /*
         * To do
         */
        Producer obj1 = new Producer();
        Consumer obj2 = new Consumer(obj1);
        var t1 = new Thread(obj1);
        var t2 = new Thread(obj2);
        t2.start();//
        t2.setName("Boring 12th standard stuff");


        System.out.println(t2);
        t1.start();
    }

}


public class Producer extends Thread{

    protected final StringBuffer sb;
  //  protected boolean dataProvider = false;
    public Producer() {
        sb = new StringBuffer("JetBrains");
    }
    public void run() {

        synchronized (sb) {
            for (int i = 0; i <= 10; i++) {

                try {
                    sb.append(" intelli j is boring me \n").append(i).append(":");
                    Thread.sleep(100);
                    System.out.println(" can you get an interview call while you sleep");
                  //  sb.wait();
                } catch (Exception e) {
                }

            }
            sb.notify();
           //
          //  System.out.println("Hi");
    //          dataProvider = true;

        }//sb.notify();
    }

}


class Consumer extends Thread{

    Producer producer;
    Consumer(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run() {
        synchronized (producer.sb) {
            try {
            /*while(!producer.dataProvider){
                Thread.sleep(10);
            }*/
                producer.sb.wait();
                //System.out.println(producer.sb);
            } catch (Exception e) {
            }
            System.out.println(producer.sb);
        }
    }
}