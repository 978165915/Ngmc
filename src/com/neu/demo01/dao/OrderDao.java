package com.neu.demo01.dao;

import com.neu.demo01.entity.Order;
import com.neu.demo01.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    //新增
    int saveOrder(Order order) throws SQLException;

    //页数
    List<Order>getOrderListByPage(int currentPage, int pageSize) throws SQLException;
    //订单表
    List<Order> getOrderList() throws SQLException;
    int getOrderCount() throws SQLException;
}
