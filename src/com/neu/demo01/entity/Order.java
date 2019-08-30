package com.neu.demo01.entity;

public class Order {
    private String title;
    private double price;
    private int amount;
    private String Orno;
    private double total;

    public Order(){
        super();
    }

    public Order(String title, double price, int amount, String orno, double total) {
        super();
        this.title = title;
        this.price = price;
        this.amount = amount;
        Orno = orno;
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrno() {
        return Orno;
    }

    public void setOrno(String orno) {
        Orno = orno;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
