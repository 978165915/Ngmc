package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.OrderDetailDao;
import com.neu.demo01.entity.OrderItem;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoImpl extends DBUtil implements OrderDetailDao {
    @Override
    public List<OrderItem> getItemsByOrderId(int id) throws SQLException {
        List<OrderItem> orderItems = new ArrayList<>();
        String sql = "SELECT ogd.*,g.`name`,g.`imgpath`" +
                " FROM `order_goods_detail` ogd,`goods` g" +
                " WHERE ogd.`itemid`=g.`id` AND `orderid`=?";
        rs = executeQuery(sql,id);
        OrderItem orderItem = null;
        while(rs.next()){
            orderItem = new OrderItem();
            orderItem.setId(rs.getInt("id"));
            orderItem.setItemid(rs.getInt("itemid"));
            orderItem.setOrderid(id);
            orderItem.setNum(rs.getInt("num"));
            orderItem.setPrice(rs.getDouble("price"));
            orderItem.setTotal(rs.getDouble("total"));
            orderItem.setGoodsname(rs.getString("name"));
            orderItem.setGoodsimg(rs.getString("imgpath"));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    @Override
    public int saveOrderItem(OrderItem orderItem) throws SQLException {
        String sql= "insert into `order_goods_detail`(itemid，orderid,price，num,total)"+
                "value(?,?,?,?,?,?,?,?)";
        return executeUpdate(sql, orderItem.getItemid(),orderItem.getOrderid(),orderItem.getPrice(),orderItem.getTotal());
    }
}
