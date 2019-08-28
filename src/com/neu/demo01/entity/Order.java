package com.neu.demo01.entity;

public class Order {
    private String title;//商品标题
    private double price;//价格
    private int amount;//数量
    private String Orno;//订单编号
    private double total;//订单总价

    public  Order(){
        super();
    }
    public Order(String title, double price, int amount, String Orno, double total) {
        super();
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.Orno = Orno;
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
