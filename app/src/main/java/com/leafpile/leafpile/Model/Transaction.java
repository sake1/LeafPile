package com.leafpile.leafpile.Model;

import com.leafpile.leafpile.Utils.StringFormat;

import java.util.Calendar;

/**
 * Created by USER on 20/11/2017.
 */

public class Transaction {

    private int id;
    private String productName;
    private String sellerName;
    private double qty;
    private int price;
    private Calendar transactionDate;

    public Transaction(int id, String productName, String sellerName, int qty, int price, Calendar transactionDate) {
        this.id = id;
        this.productName = productName;
        this.sellerName = sellerName;
        this.qty = qty;
        this.price = price;
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTotalPrice() {
        return qty * price;
    }
}
