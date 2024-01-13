package com.arbaprojek.skripsi.data.model;

import java.io.Serializable;

public class Product implements Serializable {

    public int productId;
    public String imageURIString;
    public String productName;
    public int quantity;
    public double pricePerUnit;

    boolean isChecked = false;

    public Product(int productId, String imageURIString, String productName, int quantity, double pricePerUnit) {

        this.productId = productId;
        this.imageURIString = imageURIString;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;

    }
}