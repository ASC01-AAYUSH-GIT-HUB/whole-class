package org.ecz.repository;

import org.ecz.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepositoryDbImpl implements ProductRepository {
    @Override
    public boolean addProductToCart(Product product) {
        try {
            Connection connection=getConnection();
            System.out.println("Driver Loaded!");
            Statement statement= connection.createStatement();
            System.out.println("Statement created");

            String insertQuery="INSERT INTO product (id,name,price,quantity) VALUES('"+product.getId()+"','"+product.getName()+"','"+product.getPrice()+"','"+product.getQuantity()+"');";
            int noOfRowsAffected=statement.executeUpdate(insertQuery);
            System.out.println("Number of rows affected: "+noOfRowsAffected);
            return noOfRowsAffected>0;
        } catch (SQLException sqlException) {
//            throw new RuntimeException(e);
            System.err.println(sqlException.getMessage());
        }
        return false;
    }
    private static Connection getConnection(){
        return DbConnectionSingleton.getInstance();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products=new ArrayList<>();
        try{
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()){
                String id=resultSet.getString("id");
                String name=resultSet.getString("name");
                double price=resultSet.getDouble("price");
                int quantity=resultSet.getInt("quantity");
                Product p=new Product(id,name,price,quantity);
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
//            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean updateProductToCart(Product product) {
        throw new UnsupportedOperationException("this is under decelopment");
    }
}
