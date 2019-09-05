package com.neu.demo01.dao;

import com.neu.demo01.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao {
    List<OrderItem> getItemsByOrderId(int id) throws SQLException;
    int saveOrderItem(OrderItem orderItem)throws SQLException;
}
