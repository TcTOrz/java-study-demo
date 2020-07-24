package com.company.database.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MysqlDemo {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jsbc:mysql://localhost:3306/Student?useUnicode=true&characterEncoding=utf-8&useSSL=false";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName(DBDRIVER);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
