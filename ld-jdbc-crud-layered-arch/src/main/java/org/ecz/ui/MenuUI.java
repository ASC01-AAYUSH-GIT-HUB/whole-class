package org.ecz.ui;

import org.ecz.model.Product;
import org.ecz.service.ProductService;
import org.ecz.service.ProductServiceImpl;

import java.util.List;

public class MenuUI {
    ProductService productService=new ProductServiceImpl();
    void accessMenu(){
        System.out.println("Welcome to the menu");
        System.out.println("1. Add Product");
        System.out.println("2. View Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Update Product");
        System.out.println("5. Exit");

    }
    void addProduct(){
        Product product=new Product("1003","Laptop", 10000.99,1);
        boolean isAdded= productService.addProduct(product);
        if(isAdded){
            System.out.println("Product added Successfully");
        }else{
            System.out.println("Product not added");
        }
    }
    void getAllProducts(){
        List<Product> productList=productService.getAllProducts();
        for(Product product: productList){
            System.out.println(product);
        }
    }
    void updateProduct(){
        Product product=new Product("1003","Desktop",12340.99,20);
        boolean isUpdated= productService.updateProduct(product);
        if(isUpdated){
            System.out.println("Product is Updated");
        }else{
            System.out.println("Product not updated");
        }
    }
}
