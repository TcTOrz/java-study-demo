package com.company.database.sqlite;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class SQLiteDemo {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // 需要添加sqlite lib类
            // SQLite作为轻量级数据库，并没有用户名密码的概念。
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:Student.db");
            System.out.println(connection);

            connection.close();
        }catch (Exception e) {
            System.exit(0);
        }
    }
}
