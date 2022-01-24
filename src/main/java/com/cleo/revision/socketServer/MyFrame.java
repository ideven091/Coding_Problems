package com.cleo.revision.socketServer;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame implements ItemListener {

    private String msg = " ";

    CheckboxGroup cgb;
    Checkbox y,n;

    MyFrame(){
        setLayout(new FlowLayout());

        cgb = new CheckboxGroup();
        y = new Checkbox("Yes", cgb, true);
        n = new Checkbox("No", cgb, false);

        add(y);
        add(n);
        y.addItemListener(this);
        n.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void itemStateChanged(ItemEvent ie){
        repaint();
    }
    public void paint(Graphics g){
        msg = "Current Selection";
        msg += cgb.getSelectedCheckbox().getLabel();
        g.drawString(msg,10,100);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setTitle("My Frame");
        frame.setSize(400,400);
        frame.setVisible(true);

    }
}
