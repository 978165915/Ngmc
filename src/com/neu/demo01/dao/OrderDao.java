package com.neu.demo01.dao;

import com.neu.demo01.entity.Order;

public interface OrderDao {
    // 新增卡
    int save(Order order);
}
