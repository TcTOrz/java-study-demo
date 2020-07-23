package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTButtonLabel {
    private Frame myFrame;
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;
    private Font font;

    public AWTButtonLabel() {
        myFrame = new Frame("Java按钮与标签案例");
        myFrame.setLayout(new GridLayout(3, 1));
        myFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        font = new Font("楷体", Font.PLAIN, 30);
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        headerLabel.setFont(font);
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(200, 100);
        controlPanel = new Panel();
        controlPanel.setLayout(new GridLayout());

        myFrame.add(headerLabel);
        myFrame.add(controlPanel);
        myFrame.add(statusLabel);
        myFrame.setVisible(true);
    }

    private void showButtonDemo() {
        headerLabel.setText("Button click monitor");
        Button okButton = new Button("ok");
        Button submitButton = new Button("submit");
        Button cancelButton = new Button("cancel");

        font = new Font("楷体", Font.PLAIN, 20);
        statusLabel.setFont(font);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Clicked!");
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Submit clicked!");
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Cancel clicked!");
            }
        });
        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        myFrame.pack();
        myFrame.setVisible(true);
    }

    public static void main(String[] args) {
        AWTButtonLabel awtButtonLabel = new AWTButtonLabel();
        awtButtonLabel.showButtonDemo();
    }
}
