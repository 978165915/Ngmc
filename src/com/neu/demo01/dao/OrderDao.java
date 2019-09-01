package com.neu.demo01.dao;

import com.neu.demo01.entity.Order;
import com.neu.demo01.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    int saveOrder(Order order) throws SQLException;
    int deleteOrder(Order order) throws SQLException;
    int saveOrderItem(OrderItem orderItem)throws SQLException;
    List<Order> getOrderList() throws SQLException;
}
