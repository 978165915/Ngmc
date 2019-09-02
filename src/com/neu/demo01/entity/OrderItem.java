package com.neu.demo01.entity;

public class OrderItem {
    private int id;
    private String itemid;
    private String orderid;
    private double price;
    private int num;
    private double total;

    public OrderItem(){
        super();
    }

    public OrderItem(String itemid, String orderid, double price, int num, double total) {
        super();
        this.itemid = itemid;
        this.orderid = orderid;
        this.price = price;
        this.num = num;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
