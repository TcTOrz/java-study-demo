package com.company;

import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("边界布局");
        frame.setLayout(new BorderLayout(40, 10));

        frame.add(new Button("东"), BorderLayout.EAST);
        frame.add(new Button("南"), BorderLayout.SOUTH);
        frame.add(new Button("西"), BorderLayout.WEST);
        frame.add(new Button("北"), BorderLayout.NORTH);
        frame.add(new Button("中"), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
