package com.company.database.sqlite;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentSqliteFrame extends JFrame implements ActionListener {
    private JTable mainTab; // 显示学生记录的Table
    private JButton allBtn; // 显示所有学生记录的按钮
    private JButton addBtn; // 添加新的学生记录按钮
    private JButton findBtn;    // 根据姓名查询学生记录按钮
    private JButton delBtn; // 根据学号删除学生记录按钮

    private StudentSQLiteTool tool; // 数据库操作实例

    // 列名
    private String[] tableName = {
        "学号", "姓名", "性别", "班级", "成绩", "备注"
    };

    // 列宽
    private int width[] = {
        70, 60, 50, 80, 50, 140
    };

    public StudentSqliteFrame() {
        this.setVisible(true);  // 设置界面可见
        this.setTitle("SimpleSMS"); // 标题
        this.setSize(500, 700);
        this.setResizable(false); // 窗口大小固定
        this.setLocationRelativeTo(null); // 窗口居中

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        init(); // 组件初始化
        initLayout();   // 布局初始化
    }

    // 组件初始化
    private void init() {
        tool = new StudentSQLiteTool();
        // 初始化Table
        ArrayList<Student>stuList = tool.selectAll();
        mainTab = new JTable();
        // 设置Table内容
        setTable(stuList);
        mainTab.getTableHeader().setReorderingAllowed(false); // Table列不可拖动
        mainTab.setEnabled(false); // Table不可编辑

        // 初始化按钮
        allBtn = new JButton("所有记录");
        allBtn.addActionListener(this);
        addBtn = new JButton("添加记录");
        addBtn.addActionListener(this);
        findBtn = new JButton("查询记录");
        findBtn.addActionListener(this);
        delBtn = new JButton("删除记录");
        delBtn.addActionListener(this);
    }

    private void initLayout() {
        Panel btnPal = new Panel();
        btnPal.add(allBtn);
        btnPal.add(addBtn);
        btnPal.add(findBtn);
        btnPal.add(delBtn);
        JScrollPane scroll = new JScrollPane(mainTab);
        add(scroll, BorderLayout.CENTER);
        add(btnPal, BorderLayout.SOUTH);
    }

    // 更新Table数据
    private void setTable(ArrayList<Student>stuList) {
        Object[][] objects = getObject(stuList);
        DefaultTableModel model = new DefaultTableModel(objects, tableName);
        mainTab.setModel(model);
        //  列宽
        for (int i=0; i<6; i++) {
            mainTab.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
        }
    }

    // 将stuList数组转变为Object的二维数组用于插入JTable
    private Object[][] getObject(ArrayList<Student>stuList) {
        Object[][] objects = new Object[stuList.size()][6];
        for (int i=0; i<stuList.size();i++) {
            for (int j=0;j<6;j++) {
                switch (j) {
                    case 0:
                        objects[i][j] = stuList.get(i).getId();
                        break;
                    case 1:
                        objects[i][j] = stuList.get(i).getName();
                        break;
                    case 2:
                        objects[i][j] = stuList.get(i).getSex();
                        break;
                    case 3:
                        objects[i][j] = stuList.get(i).getClassStr();
                        break;
                    case 4:
                        objects[i][j] = stuList.get(i).getScore();
                        break;
                    case 5:
                        objects[i][j] = stuList.get(i).getRemarks();
                        break;
                    default:
                        break;
                }
            }
        }
        return objects;
    }

    //通过ActionListener接口实现按钮单击事件
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(allBtn)) {
            // 显示所有学生信息
            setTable(tool.selectAll());
        }else if(e.getSource().equals(addBtn)) {
            // 添加新学生记录
            StudentInsertDialog insertDialog = new StudentInsertDialog();
            // 显示对话框，并将输入的学生信息返回
            Student stu = insertDialog.showInsertDialog();
            if(stu!=null) {
                // 插入
                if(tool.insert(stu)) {
                    setTable(tool.selectAll());
                }else {
                    JOptionPane.showMessageDialog(null, "数据添加失败！");
                }
            }
        }else if(e.getSource().equals(findBtn)) {
            // 查找
            String nameStr = JOptionPane.showInputDialog("请输入查询学生的姓名：");
            ArrayList<Student>stuList = tool.selectByname(nameStr);
            setTable(stuList);
        }else {
            try {
                // 删除
                int id = Integer.parseInt(JOptionPane.showInputDialog("请输入删除学生的学号："));
                if (tool.deleteById(id)) {
                    JOptionPane.showMessageDialog(null, id + "删除成功！");
                    setTable(tool.selectAll());
                } else {
                    JOptionPane.showMessageDialog(null, "未找到学号：" + id);
                }
            }catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "学号应为纯数字！");
            }
        }
    }

    public static void main(String[] args) {
        StudentSqliteFrame frame = new StudentSqliteFrame();
        frame.setVisible(true);
    }
}
