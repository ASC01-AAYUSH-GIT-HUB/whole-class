package com.shoppibuy.app;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ArrayList<product> products=new ArrayList<>();
        products.add(new product("A",1,2,"good",(short)4));
        products.add(new product("B",2,4,"nice",(short)6));
        products.add(new product("C",3,5,"2 use",(short)5));

        for (product p : products){
            System.out.println("Name: "+p.product_name);
        }

//        product P1=new product();
//        P1.product_name="Foot Ball";
//        P1.product_id=1;
//        P1.price=400;
//        P1.prod_details="used for playing";
//        P1.amount_left=20;
//        P1.liking=false;
//        P1.in_cart=false;
//
//        product P2=new product();
//        P2.product_name="shoes";
//        P2.product_id=2;
//        P2.price=2000;
//        P2.prod_details="used for wearing";
//        P2.amount_left=100;
//        P2.liking=false;
//        P2.in_cart=false;
//
//        product P3=new product();
//        P3.product_name="Car toy";
//        P3.product_id=3;
//        P3.price=350;
//        P3.prod_details="used for playing for kids";
//        P3.amount_left=42;
//        P3.liking=false;
//        P3.in_cart=false;
//
//        product P4=new product();
//        P4.product_name="human slave";
//        P4.product_id=4;
//        P4.price=40000;
//        P4.prod_details="used for your work";
//        P4.amount_left=5;
//        P4.liking=false;
//        P4.in_cart=false;
//
//        product P5=new product();
//        P5.product_name="Foot Massager";
//        P5.product_id=5;
//        P5.price=4000;
//        P5.prod_details="used for medical reason";
//        P5.amount_left=240;
//        P5.liking=false;
//        P5.in_cart=false;
//        System.out.println("");

    }
}
