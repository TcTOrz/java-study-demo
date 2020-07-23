package com.company;

import javax.swing.*;
import java.awt.*;

public class TestJTable {
    public static void main(String[] args) {
        Object[][] unit = {
                {"zhangsan", "85", "32", "56"},
                {"lisi", "88", "99", "100"},
                {"zhangsan", "85", "32", "56"},
                {"zhangsan", "85", "32", "56"},
                {"zhangsan", "85", "32", "56"},
                {"zhangsan", "85", "32", "56"},
        };
        Object[] name = {"name", "Chinese", "Math", "English"};
        JTable table = new JTable(unit, name);
        table.setRowHeight(30);
        table.setSelectionBackground(Color.LIGHT_GRAY);
        table.setSelectionForeground(Color.RED);
        JFrame frame = new JFrame("table");
        frame.add(new JScrollPane(table));
        frame.setSize(350, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
