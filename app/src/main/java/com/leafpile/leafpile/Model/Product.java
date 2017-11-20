package com.leafpile.leafpile.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sake on 19/11/17.
 */

public class Product implements Parcelable {

    private int id;
    private String productName;
    private String sellerName;
    private int productPrice;
    private int qty;

    public Product(int id, String productName, String sellerName, int productPrice) {
        this.id = id;
        this.productName = productName;
        this.sellerName = sellerName;
        this.productPrice = productPrice;
    }

    protected Product(Parcel in) {
        id = in.readInt();
        productName = in.readString();
        sellerName = in.readString();
        productPrice = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(productName);
        parcel.writeString(sellerName);
        parcel.writeInt(productPrice);
    }
}
