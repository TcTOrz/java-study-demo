package com.company;

import java.awt.*;
import java.awt.event.*;

public class TestMouseEvent {
    private int x,y;

    public static void main(String[] args) {
        new TestMouseEvent();
    }

    public TestMouseEvent() {
        Frame frame=  new Frame("Mouse event test");
        Label actionLabel = new Label("Mouse operation:");
        Label location = new Label("Mouse location");
        frame.setSize(300, 200);
        frame.add(actionLabel, BorderLayout.CENTER);
        frame.add(location, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        actionLabel.requestFocus();
        actionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                actionLabel.setText("operation: in label");
            }
            @Override
            public void mousePressed(MouseEvent e) {
                actionLabel.setText("operation: press in label");
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                actionLabel.setText("operation: release in label");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                actionLabel.setText("operation: click in label");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                actionLabel.setText("operation: exit in label");
            }
        });
        actionLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                location.setText("postion: X:"+x+" Y:"+y);
            }
        });
    }
}
