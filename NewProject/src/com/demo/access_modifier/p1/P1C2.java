package com.demo.access_modifier.p1;

public class P1C2 {
    public static void main(String[] args) {
        P1C1 p1c1=new P1C1();
//        p1c1.privatMethod(); //we cannot access this from another class
        p1c1.defaultMethod();
        p1c1.protectedMethod();

    }
//    String a=protectedVar;//we cannot access this as we can only use protected in case of inheritence.

}
