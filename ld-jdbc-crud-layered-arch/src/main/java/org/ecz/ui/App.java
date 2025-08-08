package org.ecz.ui;

public class App {
    public static void main(String[] args) {
        System.out.println("welcome to ECommerce App!");
        MenuUI menuUI=new MenuUI();
        menuUI.addProduct();
        menuUI.getAllProducts();
        menuUI.updateProduct();
        menuUI.getAllProducts();
    }
}
