package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.OrderDetailBiz;
import com.neu.demo01.dao.impl.OrderDetailDaoImpl;
import com.neu.demo01.entity.OrderItem;

import java.sql.SQLException;

public class OrderDetailBizImpl implements OrderDetailBiz {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        try {
            return new OrderDetailDaoImpl().saveOrderItem(orderItem);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
