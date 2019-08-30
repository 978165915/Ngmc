package com.neu.demo01.biz;

import com.neu.demo01.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderBiz {
    int save(Order order);
    int delete(Order order);
    List<Order> getOrderList();

}
