package com.cleo.revision.multiTasking;

import java.awt.*;

public class Banner extends Frame implements Runnable {

    private String str = "Cleo Empires";

    Banner(){
        setLayout(null);
        setBackground(Color.CYAN);
        setForeground(Color.red);




    }
    public void paint(Graphics g){
        Font f = new Font("Courier", Font.BOLD,40);
        g.setFont(f);
        g.drawString(str,10,100);
    }

    @Override
    public void run() {
        for(;;){
            repaint();
            try{
                Thread.sleep(400);

            }catch (InterruptedException interruptedException){}
            char ch = str.charAt(0);
            str= str.substring(1, str.length());
            str = str + ch;
        }
    }

    public static void main(String[] args) {
        Banner b = new Banner();
        b.setSize(400,400);
        b.setTitle("Cleo Rules");
        b.setVisible(true);


        Thread t = new Thread(b);
        t.start();
    }
}
