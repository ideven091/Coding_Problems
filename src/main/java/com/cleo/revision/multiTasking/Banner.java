package com.cleo.revision.multiTasking;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Banner extends JFrame implements Runnable {

    private String str = "Cleo Empires";

    Banner(){
        setLayout(null);
        setBackground(Color.CYAN);
        setForeground(Color.red);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);




    }
    public void paint(Graphics g) {
        Font f = new Font("Courier", Font.BOLD,40);
        g.setFont(f);
        g.drawString(str,10,100);
        try {
            g.drawImage(ImageIO.read(new File("src/main/resources/010.jpeg")), 0, 1, Color.CYAN, null);
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public static void main(String[] args) throws IOException {
        Banner b = new Banner();
        b.setSize(400,400);
        b.setTitle("Cleo Rules");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        ge.getMaximumWindowBounds();
        for (int j = 0; j < gs.length; j++) {
            GraphicsDevice gd = gs[j];
            GraphicsConfiguration[] gc =      gd.getConfigurations();
            for (int i=0; i < gc.length; i++) {
                JFrame f = new         JFrame(gs[j].getDefaultConfiguration());
                Canvas c = new Canvas(gc[i]);
                Rectangle gcBounds = gc[i].getBounds();
                int xoffs = gcBounds.x;
                int yoffs = gcBounds.y;
                f.getContentPane().add(c);
                f.setLocation((i*50)+xoffs, (i*60)+yoffs);
                b.add(c);

            }
        }



        Thread t = new Thread(b);
        t.start();
    }
}
