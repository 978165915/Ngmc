package com.neu.demo01.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private  int orderId;
    private String userId;
    private double total;
    private int payType;
    private int status;
    private String shipName;
    private String shipCode;
    private String createTime;
    private String closeTime;

    private List<OrderItem> list = new ArrayList<OrderItem>();

    public Order(){
        super();
    }

    public Order(int orderId, String userId, double total, int payType, int status, String shipName, String shipCode, String createTime, String closeTime) {
        super();
        this.orderId = orderId;
        this.userId = userId;
        this.total = total;
        this.payType = payType;
        this.status = status;
        this.shipName = shipName;
        this.shipCode = shipCode;
        this.createTime = createTime;
        this.closeTime = closeTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }
    public List<OrderItem> getList() {
        return list;
    }
    public void setList(List<OrderItem> list) {
        this.list = list;
    }
}
