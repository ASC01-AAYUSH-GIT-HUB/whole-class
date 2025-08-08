package org.ecz.repository;

import org.ecz.model.Product;

import java.util.*;

public class ProductRepositoryCollectionImpl implements ProductRepository {
    Map<String , Product> cart=new HashMap<>();
    Scanner s=new Scanner(System.in);

    public boolean addProductToCart(Product product){
        cart.put(product.getId(),product);
        System.out.println("Upgraded cart is "+cart);
        return true;
    }

    @Override
    public List<Product> getAllProducts(){
        List<Product> products=new ArrayList<>(cart.values());
        return products;
//        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean updateProductToCart(Product product) {
        if(cart.containsKey(product.getId())){
            cart.put(product.getId(), product);
            return true;
        }else{
            return false;
        }
//        throw new UnsupportedOperationException("not implemented yet");
    }

}
