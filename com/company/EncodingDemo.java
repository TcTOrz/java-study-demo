package com.company;

import java.io.*;

public class EncodingDemo {
    public static void main(String[] args) throws IOException {
//        byte b[] = "这是中文字符串。。。this is".getBytes("ISO8859-1");
        byte b[] = "这是中文字符串。。。this is JAVA encode test.".getBytes("GB2312");
        OutputStream out = new FileOutputStream(
                new File("D:"+
                        File.separator +
                        "项目"+
                        File.separator+
                        "java"+
                        File.separator+
                        "java-test-20200722"+
                        File.separator+
                        "src"+
                        File.separator+
                        "out.txt"));
        out.write(b);
        out.close();
    }
}
