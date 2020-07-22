package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputOutputDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("输入文件名为：");
        String inputFileName = console.next();
        System.out.println("输出文件名为：");
        String outputFileName = console.next();

        // 创建Scanner对象和PrintWrite用以处理输入数据和输出数据流
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFileName);

        int count = 0;
        double value;
        double total = 0.0;
        while(in.hasNextDouble()) {
            value = in.nextDouble();
            out.printf("%6.2f\r\n", value);
            total += value;
            count++;
        }
        out.printf("总和为：%8.2f\r\n", total);
        out.printf("均值为：%8.2f\r\n", total/count);
        in.close();
        out.close();
    }
}
