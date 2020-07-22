package com.company;

public interface InterfaceA {
    public static String INFO = "static final";
    public void print();
    default public void otherprint() {
        System.out.println("otherprint interfaceA");
    }
}
