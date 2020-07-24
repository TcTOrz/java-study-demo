package com.company.database.sqlite;
/*
 * 学生信息数据结构
 */
public class Student {
    private int id; // 学号
    private String nameStr; // 姓名
    private String sexStr; // 性别
    private String classStr; // 班级
    private int score; // 成绩
    private String remarkStr; // 备注

    public Student() {
        this.id = 0;
        this.nameStr = "";
        this.sexStr = "男";
        this.classStr = "";
        this.score = 0;
        this.remarkStr = "";
    }

    public Student(int id, String nameStr, String sexStr, String classStr, int score, String remarkStr) {
        this.id = id;
        this.nameStr = nameStr;
        this.sexStr = sexStr;
        this.classStr = classStr;
        this.score = score;
        this.remarkStr = remarkStr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getName() {
        return this.nameStr;
    }

    public void setSex(String sexStr) {
        this.sexStr = sexStr;
    }

    public String getSex() {
        return this.sexStr;
    }

    public void setClassStr(String classStr) {
        this.classStr = classStr;
    }

    public String getClassStr() {
        return this.classStr;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void setRemarks(String remarkStr) {
        this.remarkStr = remarkStr;
    }

    public String getRemarks() {
        return this.remarkStr;
    }

    public String toString() {
        return this.id + "\t" + this.nameStr + "\t" + this.sexStr + "\t" + this.classStr +
                "\t" + this.score + "\t" + this.remarkStr;
    }
}
