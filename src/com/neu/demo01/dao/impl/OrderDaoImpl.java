package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.OrderDao;
import com.neu.demo01.entity.Order;
import com.neu.demo01.entity.OrderItem;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends DBUtil implements OrderDao {

    @Override
    public int saveOrder(Order order) throws SQLException {
        String sql= "insert into order(userid,total,paytype,status,shipname,shipcode,createtime,closetime)"+
                "value(?,?,?,?,?,?,?,?)";
        return executeUpdate(sql,order.getUserId(),order.getTotal(),order.getPayType(),order.getStatus(),order.getShipName(),order.getShipCode(),order.getCreateTime(),order.getCloseTime());
    }

    @Override
    public int deleteOrder(Order order) throws SQLException {
        String sql= "delete from order where userid=?,total=?,paytype=?,status=?,shipname=?,shipcode=?,createtime=?,closetime=?";
        return executeUpdate(sql,order.getUserId(),order.getTotal(),order.getPayType(),order.getStatus(),order.getShipName(),order.getShipCode(),order.getCreateTime(),order.getCloseTime());
    };

    @Override
    public int saveOrderItem(OrderItem orderItem) throws SQLException {
        return 0;
    }

    @Override
    public List<Order> getOrderList() throws SQLException{
        List<Order>orderList = new ArrayList<>();
        String sql = "orderid,userid,total,paytype,status,shipname,shipcode,createtime,closetime";
        Order order;
        try {
            rs = executeQuery(sql);
            order = null;
            while(rs.next()){
                order = new Order();
                order.setOrderId(rs.getString("orderid"));
                order.setUserId(rs.getString("userid"));
                order.setTotal(rs.getDouble("total"));
                order.setPayType(rs.getInt("paytype"));
                order.setStatus(rs.getInt("status"));
                order.setShipName(rs.getString("shipname"));
                order.setShipCode(rs.getString("shipcode"));
                order.setCreateTime(rs.getDate("createtime"));
                order.setCloseTime(rs.getDate("closetime"));
                orderList.add(order);
            }
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return orderList;
    }
}
