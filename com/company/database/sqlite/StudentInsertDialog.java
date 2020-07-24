package com.company.database.sqlite;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.ParseException;

public class StudentInsertDialog extends JDialog {
    private Student stu;    // 存储用户输入的学生信息
    private JLabel idLab;   // 学号标签
    private JLabel nameLab; // 姓名标签
    private JLabel sexLab;  // 性别标签
    private JLabel classLab;    // 班级标签
    private JLabel scoreLab;    // 成绩标签
    private JLabel remarkLab;   // 备注标签

    private JFormattedTextField idText; // 学号输入框，限定输入数字
    private JTextField nameText;    // 姓名输入框
    private JComboBox<String>sexBox;    // 性别选择框，限定男/女
    private JComboBox<String>classBox;  // 班级选择框，限定班级选择
    private JFormattedTextField scoreText;  // 成绩输入框，限定数字
    private JTextField remarkText;  // 备注输入框

    private JButton okBtn;  // 确定按钮，返回输入的学生信息
    private JButton exitBtn;    // 取消按钮，返回空值

    public StudentInsertDialog() {
        init(); // 调用组件初始化方法
        initLayout();   // 调用布局方法
    }

    // 组件初始化方法
    public void init() {
        // 窗口初始化
        this.setTitle("添加学生信息");
        this.setSize(210, 250);
        this.setLocationRelativeTo(null);   // 窗口居中
        this.setModal(true);    // 设置静态
        this.setBackground(Color.WHITE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 控件初始化
        idLab = new JLabel("学号：");
        nameLab = new JLabel("姓名：");
        sexLab = new JLabel("性别：");
        classLab = new JLabel("班级：");
        scoreLab = new JLabel("成绩：");
        remarkLab = new JLabel("备注：");

        try{
            // 限制输入内容必须为8位数字
            MaskFormatter formatter = new MaskFormatter("########");
            idText = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        idText.setPreferredSize(new Dimension(120, 25));
        nameText = new JTextField();
        nameText.setPreferredSize(new Dimension(120, 25));
        String[] sexList = {"男", "女"};
        sexBox = new JComboBox<>(sexList);
        sexBox.setPreferredSize(new Dimension(120, 25));
        String[] classList = {"一班", "二班", "三班", "四班"};
        classBox = new JComboBox<>(classList);
        classBox.setPreferredSize(new Dimension(120, 25));
        // 限制输入必须是数字
        scoreText = new JFormattedTextField(NumberFormat.getIntegerInstance());
        scoreText.setPreferredSize(new Dimension(120, 25));
        remarkText = new JTextField();
        remarkText.setPreferredSize(new Dimension(120, 25));

        okBtn = new JButton("确定");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idText.getText().equals("")
                ||nameText.getText().equals("")
                ||scoreText.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "新增学生信息有误！");
                    return;
                }
                int id = Integer.parseInt(idText.getText());
                String name = nameText.getText();
                String sex = sexBox.getSelectedItem().toString();
                String clas = classBox.getSelectedItem().toString();
                int score = Integer.parseInt(scoreText.getText());
                String remark = remarkText.getText();
                stu = new Student(id, name, sex, clas, score, remark);
                setVisible(false);
            }
        });

        exitBtn = new JButton("取消");
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    // 布局方法
    public void initLayout() {
        Panel idPanel = new Panel();
        idPanel.add(idLab);
        idPanel.add(idText);
        Panel namePanel = new Panel();
        namePanel.add(nameLab);
        namePanel.add(nameText);
        Panel sexPanel = new Panel();
        sexPanel.add(sexLab);
        sexPanel.add(sexBox);
        Panel classPanel = new Panel();
        classPanel.add(classLab);
        classPanel.add(classBox);
        Panel scorePanel = new Panel();
        scorePanel.add(scoreLab);
        scorePanel.add(scoreText);
        Panel remarkPanel = new Panel();
        remarkPanel.add(remarkLab);
        remarkPanel.add(remarkText);

        Panel mainPanel = new Panel();
        mainPanel.setLayout(new GridLayout(6, 1));
        mainPanel.add(idPanel);
        mainPanel.add(namePanel);
        mainPanel.add(sexPanel);
        mainPanel.add(classPanel);
        mainPanel.add(scorePanel);
        mainPanel.add(remarkPanel);

        Panel southPanel = new Panel();
        southPanel.add(okBtn);
        scorePanel.add(exitBtn);

        add(mainPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    // 显示对话框并在关闭时返回输入学生的信息
    public Student showInsertDialog() {
        setVisible(true);
        return this.stu;
    }
}
