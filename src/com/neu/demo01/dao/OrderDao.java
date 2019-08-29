package com.neu.demo01.dao;

import com.neu.demo01.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    int save(Order order) throws SQLException;
    int delete(Order order) throws SQLException;
    List<Order> getOrderList() throws SQLException;
}
