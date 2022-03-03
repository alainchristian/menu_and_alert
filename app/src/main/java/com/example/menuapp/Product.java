package com.example.menuapp;

public class Product {
    int prodImage;
    String prodName;
    long prodPrice;
    String prodDescr;

    public Product(int prodImage, String prodName, long prodPrice, String prodDescr) {
        this.prodImage = prodImage;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodDescr = prodDescr;
    }

    public int getProdImage() {
        return prodImage;
    }

    public void setProdImage(int prodImage) {
        this.prodImage = prodImage;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public long getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(long prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdDescr() {
        return prodDescr;
    }

    public void setProdDescr(String prodDescr) {
        this.prodDescr = prodDescr;
    }
}
