package com.demo.debugging;

public class DebuggingTools {
    public static void main(String[] args) {
        System.out.println("Debugging tools are essential for software development.");
        int a=10;
        int b=12;
        add(a,b);
    }
    private static void add(int a,int b){
        System.out.println(a+b);

    }
}
