package com.cleo.revision.socketServer;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class  MultiServe implements Runnable{

    static ServerSocket ss;
    static Socket s;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(;;){
            try {
                System.out.println("Thread: " + name + " ready to accept");
                s = ss.accept();
                System.out.println("Thread " + name + " accepted a connection" );
                PrintStream ps = new PrintStream(s.getOutputStream());
                ps.println("Thread " + name + " contacted you");
                ps.close();
                s.close();
            }catch (Exception ignored){}
        }
    }

    public static void main(String[] args) throws Exception {
        MultiServe ms = new MultiServe();
        ss = new ServerSocket(999);

        Thread t1 = new Thread(ms, "One");
        Thread t2 = new Thread(ms, "two");
        t1.start();

        t2.start();
    }
}
