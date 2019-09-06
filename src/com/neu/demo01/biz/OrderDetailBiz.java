package com.neu.demo01.biz;

import com.neu.demo01.entity.OrderItem;

import java.sql.SQLException;

public interface OrderDetailBiz {
     int saveOrderItem(OrderItem orderItem);
}
