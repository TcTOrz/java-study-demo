package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestTextField {
    public static void main(String[] args) {
        Frame frame = new Frame("Text field test");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Label message = new Label("print msg");
        TextField text = new TextField(10);
        Panel centerPanel = new Panel();
        Button enter = new Button("ok");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message.setText(text.getText());
            }
        });
        frame.add(message, BorderLayout.NORTH);
        centerPanel.add(text);
        centerPanel.add(enter);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setSize(300, 200);
//        frame.pack();
        frame.setVisible(true);
    }
}
