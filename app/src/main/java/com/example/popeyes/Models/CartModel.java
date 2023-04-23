package com.example.popeyes.Models;

public class CartModel {
    int image;
    String soldItemName,price,order_number;

    public CartModel(int image, String soldItemName, String price, String order_number) {
        this.image = image;
        this.soldItemName = soldItemName;
        this.price = price;
        this.order_number = order_number;
    }

    public CartModel() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }
}
