package com.company.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestStudentManager {
    private int rows = 0;
    private String[][] unit = new String[rows][5];
    private String[] name = {"姓名", "语文", "数学", "外语", "总分"};

    public static void main(String[] args) {
        new TestStudentManager();
    }
    TestStudentManager() {
        JFrame frame = new JFrame("模拟学生管理系统");
        final JTable[] table = {new JTable(unit, name)};
        JPanel southPanel = new JPanel();
        southPanel.add(new JLabel("添加学生成绩"));
        JButton calc = new JButton("计算成绩");
        JButton save = new JButton("保存学生成绩");
        JTextField input = new JTextField(5);
        southPanel.add(input);
        southPanel.add(calc);
        southPanel.add(save);
        frame.add(new JLabel("欢迎访问学生管理系统！"), BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.add(new JScrollPane(table[0]), BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rows = Integer.valueOf(input.getText());
                unit = new String[rows][5];
                table[0] = new JTable(unit, name);
                frame.getContentPane().removeAll();
                frame.add(new JScrollPane(table[0]), BorderLayout.CENTER);
                frame.add(southPanel, BorderLayout.SOUTH);
                frame.add(new JLabel("欢迎访问学生管理系统！"), BorderLayout.NORTH);
                frame.validate();
                table[0].setRowHeight(25);
            }
        });

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<rows; i++) {
                    double sum = 0;
                    boolean flag = true;
                    for (int j=1; j<=3; j++) {
                        try {
                            sum += Double.valueOf(unit[i][j].toString());
                        }catch (Exception ee) {
                            flag = false;
                            table[0].repaint();
                        }
                        if (flag) {
                            unit[i][4] = ""+sum;
                            table[0].repaint();
                        }
                    }
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    write();
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    void write() throws IOException {
        File f = new File("D:"+
                File.separator +
                "项目"+
                File.separator+
                "java"+
                File.separator+
                "java-test-20200722"+
                File.separator+
                "src"+
                File.separator+
                "学生信息.txt");
        FileWriter fw = new FileWriter(f);
        for (int i=0; i<5;i++) {
            fw.write(name[i] + "\t");
        }
        fw.write("\r\n");
        for (int i=0; i<rows; i++) {
            for (int j=0; j<5;j++) {
                fw.write(unit[i][j] + "\t");
            }
            fw.write("\r\n");
        }
        fw.close();
        JOptionPane.showMessageDialog(null, "save success!");
    }
}
