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
        String sql= "delete from order where orderid=? userid=?,total=?,paytype=?,status=?,shipname=?,shipcode=?,createtime=?,closetime=?";
        return executeUpdate(sql,order.getOrderId(),order.getUserId(),order.getTotal(),order.getPayType(),order.getStatus(),order.getShipName(),order.getShipCode(),order.getCreateTime(),order.getCloseTime());
    };

    @Override
    public int saveOrderItem(OrderItem orderItem) throws SQLException {
        return 0;
    }

    @Override
    public List<Order> getOrderListByPage(int currentPage, int pageSize) throws SQLException {
        List<Order>orderList = new ArrayList<>();
        String sql = "select orderid,userid,total,paytype,status,shipname,shipcode,createtime,closetime from `order` limit ?,?";
        Order order;
        try {
            rs = rs = executeQuery(sql,(currentPage-1)*pageSize,pageSize);
            order = null;
            while(rs.next()){
                order = new Order();
                order.setOrderId(rs.getInt("orderid"));
                order.setUserId(rs.getString("userid"));
                order.setTotal(rs.getDouble("total"));
                order.setPayType(rs.getInt("paytype"));
                order.setStatus(rs.getInt("status"));
                order.setShipName(rs.getString("shipname"));
                order.setShipCode(rs.getString("shipcode"));
                order.setCreateTime(rs.getString("createtime"));
                order.setCloseTime(rs.getString("closetime"));
                orderList.add(order);
            }
        } finally {
            closeAll(conn, pstmt, rs);//关闭资源
        }
        return orderList;//返回集合

    }

    @Override
    public List<Order> getOrderList() throws SQLException{
        List<Order>orderList = new ArrayList<>();
        String sql = "select orderid,userid,total,paytype,status,shipname,shipcode,createtime,closetime from order";
        Order order;
        try {
            rs = executeQuery(sql);
            order = null;
            while(rs.next()){
                order = new Order();
                order.setOrderId(rs.getInt("orderid"));
                order.setUserId(rs.getString("userid"));
                order.setTotal(rs.getDouble("total"));
                order.setPayType(rs.getInt("paytype"));
                order.setStatus(rs.getInt("status"));
                order.setShipName(rs.getString("shipname"));
                order.setShipCode(rs.getString("shipcode"));
                order.setCreateTime(rs.getString("createtime"));
                order.setCloseTime(rs.getString("closetime"));
                orderList.add(order);
            }
        } finally {
            closeAll(conn, pstmt, rs);//关闭资源
        }
        return orderList;//返回集合
    }

    @Override
    public int getOrderCount() throws SQLException {
        int count=0;
        String sql="SELECT COUNT(orderid) FROM order";
        try{
            rs=executeQuery(sql,null);
            if(rs.next()){
                count=rs.getInt(1);
            }
        }finally {
            closeAll(conn,pstmt,rs);
        }
        return count;
    }
}
