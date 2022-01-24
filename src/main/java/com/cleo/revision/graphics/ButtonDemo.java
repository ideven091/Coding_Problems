package com.cleo.revision.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Goal to learn java 8 lambda and asynchronous programming
 * Make a multi threaded chat application
 */

public class ButtonDemo extends JFrame implements ActionListener {

    private  JButton button;
    private JLabel label;

    public ButtonDemo(){

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon imageIcon = new ImageIcon("car6.jpg");
        button = new JButton("Click me", imageIcon);

        button.setBackground(Color.YELLOW);
        button.setForeground(Color.red);

        button.setFont(new Font("Arial", Font.BOLD, 30));

        button.setToolTipText("This is a button");

        button.setMnemonic('C');

        c.add(button);
        button.addActionListener(this);

        label = new JLabel();
        c.add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void actionPerformed(ActionEvent ae){
            ImageIcon li = new ImageIcon("car6.jpg");
            label.setIcon(li);

    }

    public static void main(String[] args) {
        ButtonDemo obj = new ButtonDemo();
        obj.setTitle("A new Button");
        obj.setVisible(true);
        obj.setSize(400,400);
    }
}
