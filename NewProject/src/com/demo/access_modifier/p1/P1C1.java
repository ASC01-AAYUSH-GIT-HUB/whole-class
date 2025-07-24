package com.demo.access_modifier.p1;

public class P1C1 {
    //instance Variable
    private String privateVar;

    private void privateMethod() {
        System.out.println("abc");
    }
    String defaultVar;

    void defaultMethod() {
        System.out.println("abc");
    }
    protected String protectedVar;

    protected void protectedMethod() {
        System.out.println("abc");
    }

    public static void main(String[] args) {
        P1C1 p1c1;
        p1c1 = new P1C1();
        p1c1.privateMethod();
    }
}
