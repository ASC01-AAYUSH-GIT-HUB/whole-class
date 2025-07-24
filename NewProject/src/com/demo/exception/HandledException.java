package com.demo.exception;

public class HandledException {
    public static void main(String[] args) {
        int i=100;
        int res=0;
        int j=0;
        System.out.println("trying to divide by 0");
        try{
            res=i/j;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
//            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("your code is done");
        }
        System.out.println(res);
    }
}
