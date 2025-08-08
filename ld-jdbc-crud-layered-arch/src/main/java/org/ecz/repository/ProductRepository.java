package org.ecz.repository;

import org.ecz.model.Product;

import java.util.List;

public interface ProductRepository {
    boolean addProductToCart(Product product);
    List<Product> getAllProducts();
    boolean updateProductToCart(Product product);
}
