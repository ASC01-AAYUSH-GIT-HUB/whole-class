package com.demo.collection;

import java.util.*;

public class MapEx {
    public static void main(String[] args) {
        m2();
    }
    private static void m1(){
        Map<Object,Object> map1=new HashMap<Object,Object>();
        Laptop l1=new Laptop("ideapad",100);
        Laptop l2=new Laptop("inspiron",120);
        Laptop l3=new Laptop("pavelion",90);
        Laptop l4=new Laptop("TUF",90);
        Laptop l5=new Laptop("MacBook",90);
        Laptop l6=new Laptop("thinkpad",90);
        String brand="HP";
        map1.put("Lenevo",l1);
        map1.put(brand,l2);
//        System.out.println(map1);
        map1.put("HP",l3);
        map1.put("null",l4);
        map1.put(null,l5);
        map1.put(null,l6);
        System.out.println(map1);

    }
    private static void m0(){
        Map<String,String> map2=new HashMap<String,String>();
        map2.put("Good life","Stress free life");
        map2.put("Good action","Multiple perameters considaration");
        Scanner s=new Scanner(System.in);
        String keY=s.nextLine();
        String val=s.nextLine();
        map2.put(keY,val);
        System.out.println(map2);
    }
    private static void m2(){
        Map<Object,Object> map3=new TreeMap<Object,Object>();//treeMap prints keys in order unlike HashMap
        Laptop l1=new Laptop("ideapad",100);
        Laptop l2=new Laptop("inspiron",120);
        Laptop l3=new Laptop("pavelion",90);
        Laptop l4=new Laptop("TUF",90);
        Laptop l5=new Laptop("MacBook",90);
        Laptop l6=new Laptop("thinkpad",90);
        String brand="HP";
        map3.put("Senevo",l1);
        map3.put(brand,l2);
//        System.out.println(map1);
        map3.put("HP",l3);
        map3.put("null",l4);
//        map3.put(null,l5);
//        map3.put(null,l6);
//        System.out.println(map3);
//        Collection <Object> values=map3.values();
//        for(Object v:values) {
//            System.out.println(v);
//        }
//        for(Object v:map3.values()) {//can do by this also
//            System.out.println(v);
//        }
//        Collection<Object> keys=map3.keySet();//we can write this also
        Set<Object> set=map3.keySet();
        for(Object k: set){
            System.out.println(map3.get(k)+" "+k);
        }
        for(Object k: map3.keySet()){
            System.out.println(k);
        }

    }
}

class Laptop{
    String laptopName;
    float price;

    public Laptop(String laptopNames,float price){
        laptopName=laptopNames;
        this.price=price;
    }
    @Override
    public String toString(){
        return "Laptop [laptop:"+laptopName+"   price: "+price+"]";
    }
}