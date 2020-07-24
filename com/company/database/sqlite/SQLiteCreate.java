package com.company.database.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteCreate {
    public static void main(String[] args) {
        // 数据库连接对象
        Connection conn = null;
        // 用于向数据库发送SQL语句
        Statement stmt = null;

        String sql = "CREATE TABLE STUDENT " +
                "(ID INT PRIMARY KEY NOT NULL," +
                "NAME CHAR(10) NOT NULL," +
                "SEX CHAR(10) NOT NULL,"+
                "CLASS CHAR(50) NOT NULL,"+
                "SCORE INT NOT NULL,"+
                "REMARK CHAR(100))";
        try {
            // 加载数据库驱动程序
            Class.forName("org.sqlite.JDBC");
            // 连接数据库
            conn = DriverManager.getConnection("jdbc:sqlite:student.db");
            // 实例化
            stmt = conn.createStatement();
            // 执行sql
            stmt.executeUpdate(sql);
            System.out.println("STUDENT表新建成功");
            // 关闭数据库
            stmt.close();
        }catch (Exception e) {
            System.exit(0);
        }
    }
}
