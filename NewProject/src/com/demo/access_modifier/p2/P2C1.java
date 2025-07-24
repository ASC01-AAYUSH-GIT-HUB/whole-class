package com.demo.access_modifier.p2;
import com.demo.access_modifier.p1.P1C1;

public class P2C1 extends P1C1 {
    public static void main(String[] args) {
        P1C1 p1c1=new P1C1();
//        p1c1.privatMethod(); //we cannot access this from another package
//        p1c1.defaultMethod(); //we cannot access this from another package
//
    }
    String a=protectedVar;
}


