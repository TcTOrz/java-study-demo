package com.company;

public class ThrowDemo {
    public static void main(String[] args) {
        int[] arr = new int[5];
        try {
//            ThrowDemo t = new ThrowDemo();
            setZero(arr, 10);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("异常:"+e);
        }
        System.out.println("main方法结束");
    }

    public static void setZero(int[] arr, int index) throws ArrayIndexOutOfBoundsException {
        System.out.println("-----------setZero开始-----------");
        try {
            arr[index] = 0;
        }catch (ArrayIndexOutOfBoundsException ex) {
            throw ex;
        }finally {
            System.out.println("-----------setZero结束-----------");
        }
    }
}
