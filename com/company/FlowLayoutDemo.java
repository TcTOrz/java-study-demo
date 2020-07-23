package com.company;

import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("流式布局");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        for (int count=0; count<20; count++) {
            frame.add(new Button("button"+count));
        }
        frame.pack();
        frame.setVisible(true);
    }
}
