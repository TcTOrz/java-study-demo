package com.company;

import java.awt.*;

public class BorderLayoutDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("网格布局之计算器");
        Panel panel = new Panel();
        panel.add(new TextField(40));
        frame.add(panel, BorderLayout.NORTH);

        // 定义面板
        Panel gridPanel = new Panel();
        // 设置网格布局
        gridPanel.setLayout(new GridLayout(4, 4, 3, 3));
        String name[] = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        for (int i=0; i<name.length; i++) {
            gridPanel.add(new Button(name[i]));
        }

        frame.add(gridPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
