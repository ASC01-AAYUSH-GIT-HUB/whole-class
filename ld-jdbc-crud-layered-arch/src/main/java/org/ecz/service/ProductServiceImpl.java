package org.ecz.service;

import org.ecz.model.Product;
import org.ecz.repository.ProductRepository;
import org.ecz.repository.ProductRepositoryCollectionImpl;

import java.util.Collections;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository=new ProductRepositoryCollectionImpl();
    @Override
    public boolean addProduct(Product product) {
        boolean isAdded=false;
        if(product.getPrice()<0){
            System.out.println("Price can't be negative");
        }else{
            isAdded=productRepository.addProductToCart(product);
        }
        return isAdded;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public boolean updateProduct(Product product) {
//        throw new UnsupportedOperationException("this is under process");
        boolean isUpdated;
        isUpdated=productRepository.updateProductToCart(product);
        return isUpdated;
    }
}
