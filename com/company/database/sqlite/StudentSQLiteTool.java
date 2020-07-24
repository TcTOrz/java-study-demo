package com.company.database.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentSQLiteTool {
    private String driver = "org.sqlite.JDBC";
    private String name = "jdbc:sqlite:Student.db";

    private Connection conn = null;
    private PreparedStatement stmt = null;

    public StudentSQLiteTool() {
        try {
            // 加载驱动
            Class.forName(driver);
            // 连接数据库
            conn = DriverManager.getConnection(name);

            conn.setAutoCommit(false);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 添加新记录
    public boolean insert(Student stu) {
        boolean flag = false;
        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?);";;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, stu.getId());
            stmt.setString(2, stu.getName());
            stmt.setString(3, stu.getSex());
            stmt.setString(4, stu.getClassStr());
            stmt.setInt(5, stu.getScore());
            stmt.setString(6, stu.getRemarks());

            if(stmt.executeUpdate()!=0) {
                flag = true;
            }
            stmt.close();
            conn.commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    // 查询所有学生信息
    public ArrayList<Student>selectAll() {
        ArrayList<Student>stuList = null;
        // 结果集，用于存储和操作查询到的多个结果
        ResultSet set = null;
        String sql = "SELECT * FROM STUDENT;";
        try {
            stmt = conn.prepareStatement(sql);
            //调用ececuteQuery方法，将结果存入ResultSet实例中
            set = stmt.executeQuery();
            stuList = new ArrayList<>();

            while (set.next()) {
                int id = set.getInt("ID");
                String name = set.getString("NAME");
                String sex = set.getString("SEX");
                String clas = set.getString("CLASS");
                int score = set.getInt("SCORE");
                String remark = set.getString("REMARK");
                stuList.add(new Student(id, name, sex, clas, score, remark));
            }

            set.close();
            stmt.close();
            conn.commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stuList;
    }

    // 通过姓名查询学生记录
    public ArrayList<Student>selectByname(String nameStr) {
        ArrayList<Student>stuList = null;
        ResultSet set = null;
        String sql = "SELECT * FROM STUDENT WHERE NAME LIKE ?;";
        try {
            stuList = new ArrayList<>();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%"+nameStr+"%");
            set = stmt.executeQuery();

            while(set.next()) {
                int id = set.getInt("ID");
                String name = set.getString("NAME");
                String sex = set.getString("SEX");
                String clas = set.getString("CLASS");
                int score = set.getInt("SCORE");
                String remark = set.getString("REMARK");
                stuList.add(new Student(id, name, sex, clas, score, remark));
            }

            set.close();
            stmt.close();
            conn.commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stuList;
    }

    // 根据学号删除学生信息
    public boolean deleteById(int id) {
        boolean flag = false;
        String sql = "DELETE FROM STUDENT WHERE ID=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            if(stmt.executeUpdate()!=0) {
                flag = true;
            }
            stmt.close();
            conn.commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}
