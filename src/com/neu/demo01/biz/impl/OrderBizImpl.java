package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.OrderBiz;
import com.neu.demo01.dao.impl.OrderDaoImpl;
import com.neu.demo01.dao.impl.OrderDetailDaoImpl;
import com.neu.demo01.entity.Order;
import com.neu.demo01.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;

public class OrderBizImpl implements OrderBiz {

    @Override
    public int saveOrder(Order order) {
        try {
            return new OrderDaoImpl().saveOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        return 0;
    }

    @Override
    public List<Order> getOrderListByPage(int currentPage, int pageSize) {
        try {
            return new OrderDaoImpl().getOrderListByPage(currentPage, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> getOrderList() {
        try {
            List<Order> orderList = new OrderDaoImpl().getOrderList();
            //装载订单对应的商品项列表
            for (int i = 0; i <orderList.size() ; i++) {
                Order o = orderList.get(i);
                o.setOrderItems(new OrderDetailDaoImpl().getItemsByOrderId(o.getOrderId()));
            }
            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getOrderCount() {
        try {
            return new OrderDaoImpl().getOrderCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}