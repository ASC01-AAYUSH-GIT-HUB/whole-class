package com.demo.exception;

public class UnhandledException {
    public static void main(String[] args) {
        int i = 100;
        System.out.println("divide by zero");
        int res=i/0;
        System.out.println("this will not executed, abruptly terminated");
        System.out.println(res);
    }
}
