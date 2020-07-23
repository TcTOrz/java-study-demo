package com.company;

import java.util.Scanner;

public class InoutWorldsDemo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        console.useDelimiter("[^A-Za-z]+");
        while (console.hasNext()) {
            String input = console.next();
            System.out.println(input);
        }
        console.close();
    }
}
