package com.demo.oops;

public class StaticVsInstanceEx {
    public static void main(String args[]){
        Employee.companyName="Ascendion";
        System.out.println("Company name: "+Employee.companyName);
        Employee emp1=new Employee();
        emp1.empName="Aayush";
        System.out.println(emp1.empName);
        Employee emp2=new Employee();
        emp2.empName="Prasad";
        System.out.println(emp2.empName);
        emp1.companyName="Cognisiya";
        System.out.println(emp2.companyName);
        System.out.println(Employee.companyName);
    }
}
class Employee{
    public static String companyName="My new company";
    public String empName;
}
