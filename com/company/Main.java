package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Student s = new Student("张三", 10, "学生");
        System.out.println(s.talk());


        SubClass subO = new SubClass();
        subO.print();
        subO.otherprint();

        int Num;
        RandomDie die = new RandomDie(6);
        final int TRIES = 15;
        for (int i = 1; i <= TRIES; i++ ) {
            Num = die.cast();
            System.out.print(Num);
        }
        System.out.println();

        try {
            int arr[] = new int[5];
            arr[10] = 6;
        }catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("errorrrrrrrrr");
        }finally {
            System.out.println("finallyyyyyyyyyy");
        }
    }
}
