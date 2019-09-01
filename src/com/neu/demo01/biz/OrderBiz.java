package com.neu.demo01.biz;

import com.neu.demo01.entity.Order;
import com.neu.demo01.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderBiz {
    int saveOrder(Order order);
    int deleteOrder(Order order);
    int saveOrderItem(OrderItem orderItem);
    List<Order> getOrderList();

}
