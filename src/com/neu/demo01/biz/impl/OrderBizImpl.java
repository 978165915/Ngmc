package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.OrderBiz;
import com.neu.demo01.dao.impl.OrderDaoImpl;
import com.neu.demo01.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderBizImpl implements OrderBiz {

    @Override
    public int save(Order order) {
        try {
            return new OrderDaoImpl().save(order);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
    }

    @Override
    public int delete(Order order) {
        try {
            return new OrderDaoImpl().delete(order);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Order> getOrderList() {
        try {
            return new OrderDaoImpl().getOrderList();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
