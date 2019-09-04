package com.neu.demo01.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private  int orderId;//订单编号
    private String userId;//用户编号
    private double total;//总价
    private int payType;//支付类型
    private int status;//订单状态
    private String shipName;//物流名称
    private String shipCode;//物流单号
    private String createTime;//创建时间
    private String closeTime;//关闭时间

    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
