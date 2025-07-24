package com.shoppibuy.app;

public class product {

    String product_name;
    int product_id;
    int price;
    String prod_details;
    short amount_left;
    Boolean liking;
    Boolean in_cart;

    public product(String product_name,int product_id,int price,String prod_details,short amount_left){
        this.product_name=product_name;
        this.product_id=product_id;
        this.price=price;
        this.amount_left=amount_left;
        this.prod_details=prod_details;
        this.liking=false;
        this.in_cart=false;
    }
}
