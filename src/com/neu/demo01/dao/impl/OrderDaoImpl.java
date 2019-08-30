package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.OrderDao;
import com.neu.demo01.entity.Order;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends DBUtil implements OrderDao {
    @Override
    public int save(Order order) throws SQLException{
        String sql= "insert into order(price,amount,Orno,total,title)"+
                "value(?,?,?,?,?)";
        return executeUpdate(sql,order.getPrice(),order.getAmount(),order.getOrno(),order.getTotal(),order.getTitle());

    }

    @Override
    public int delete(Order order) throws SQLException {
        String sql= "delete from order where price=?,amount=?,Orno=?,total=?title=?";
        return executeUpdate(sql,order.getPrice(),order.getAmount(),order.getOrno(),order.getTotal(),order.getTitle());

    }

    @Override
    public List<Order> getOrderList() throws SQLException{
        List<Order>orderList = new ArrayList<>();
        String sql = "select price,amount,Orno,total,title from order";
        Order order;
        try {
            rs = executeQuery(sql);
            order = null;
            while(rs.next()){
                order = new Order();
                order.setPrice(rs.getDouble("price"));
                order.setAmount(rs.getInt("amount"));
                order.setOrno(rs.getString("Orno"));
                order.setTotal(rs.getDouble("total"));
                order.setTitle(rs.getString("title"));

                orderList.add(order);
            }
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return orderList;
    }
}
