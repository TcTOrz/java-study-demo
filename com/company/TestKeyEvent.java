package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestKeyEvent {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Label message = new Label("press any key", Label.CENTER);
        Label keyChar = new Label("", Label.CENTER);
        frame.setSize(300, 200);
        frame.requestFocus();
        frame.add(message, BorderLayout.NORTH);
        frame.add(keyChar, BorderLayout.CENTER);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyChar.setText(KeyEvent.getKeyText(e.getKeyCode())+" pressed.");
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
