package com.demo.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
    public static void main(String[] args) {
//        rawTypes();
//        genericTypes();
//        multiType();
        workWithArrayList();
    }
    private static void rawTypes(){
        //ArrayList without generics(raw type)
        //ArrayList allows any type of object to be added.
        //this is not safe as it can lead to run time error
        ArrayList colorlist= new ArrayList();
        colorlist.add("red");
        colorlist.add("green");
        colorlist.add("blue");
        ArithmeticException e=new ArithmeticException("there is an arithmetic error");
        colorlist.add(e);
        colorlist.add(3,null);
        System.out.println(colorlist);
    }
    private static void genericTypes(){
        //ArrayList without generics(raw type)
        //ArrayList allows any type of object to be added.
        //this is not safe as it can lead to run time error
        ArrayList<String> colorlist= new ArrayList<>();
        colorlist.add("red");
        colorlist.add("green");
        colorlist.add("blue");
        ArithmeticException e=new ArithmeticException("there is an arithmetic error");
        colorlist.add(String.valueOf(e));//now we cannot put "e" directly in "colorlist" as "colorlist" can take String type values
        colorlist.add(e.toString());//we can also use ".toString()" for converting things to String
        colorlist.add(1,null);
        System.out.println(colorlist);
        ArrayList<Integer> luckyNumber=new ArrayList<Integer>();
        luckyNumber.add(2);
        luckyNumber.add(null);
        luckyNumber.add(10);
        luckyNumber.add(1,3);
        System.out.println(luckyNumber);
    }
    private static void multiType(){
        //10 is an int, but it is autoboxed to Integer
        //Boxing converts primitive types to Wrapper class
        //we can use .valueOf() for conversion
        ArrayList<Number> a = new ArrayList<Number>();
        int num=10;
        a.add(Integer.valueOf(num));
        a.add(num);//Autoboxing also happens
        a.add(1);
        a.add(1.2f);
        a.add(10000.12345);
        System.out.println(a);

    }
    public static void workWithArrayList(){
        ArrayList<String> shoppingCartList=new ArrayList<>();
        shoppingCartList.add("Man's search for Meaning");
        shoppingCartList.add("Start with Why");
        shoppingCartList.add("Java");
        shoppingCartList.add("Start with Why");
        shoppingCartList.add("Deep Work");
        shoppingCartList.set(1,"start with Why: Updated");
        System.out.println("1: "+shoppingCartList.get(3));
        shoppingCartList.remove(3);
        System.out.println(shoppingCartList);
        shoppingCartList.add(null);
        shoppingCartList.add(null);
        System.out.println(shoppingCartList);
        for(String items: shoppingCartList){
            System.out.println(items);
        }
        System.out.println("Size of cart: "+shoppingCartList.size());
        ArrayList<String> removeAllinArraylist=new ArrayList<>();
        removeAllinArraylist.add("Start with Why");
        removeAllinArraylist.add("Java");
        removeAllinArraylist.add(null);
//        remove all elements form shoppingCartList which are in removeAllinArraylist
        shoppingCartList.removeAll(removeAllinArraylist);
        System.out.println(shoppingCartList);
        System.out.println(removeAllinArraylist.isEmpty());
        removeAllinArraylist.remove(2);
        System.out.println(removeAllinArraylist);
        System.out.println(removeAllinArraylist.size());
        removeAllinArraylist.iterator().hasNext();
    }

}
//we cannot use primitive type directly in ArrayList,so we need to use the wrapper class
//primitive type-byte,short,int,long,float,double,char,boolean
//Wrapper class-Byte,Short,Integer,Long,Float,Double,Character,Boolean
