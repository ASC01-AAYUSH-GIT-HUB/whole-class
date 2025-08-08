package org.ecz.service;

import org.ecz.model.Product;

import java.util.List;

public interface ProductService {
    public boolean addProduct(Product product);
    public List<Product> getAllProducts();
    public boolean updateProduct(Product product);
}
