package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.CarouselDao;
import com.neu.demo01.entity.Carousel;
import com.neu.demo01.entity.User;
import com.neu.demo01.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarouselDaoImpl extends DBUtil implements CarouselDao {
    @Override
    public int save(Carousel carousel) throws SQLException {
        String sql = "insert into carousel(`id`,`carDesc`,`imgpath`,`createtime`) values ( ?, ?, ?, ?)";
        return executeUpdate(sql, carousel.getId(), carousel.getCardesc(), carousel.getImgpath(), carousel.getCreatetime());
    }

    @Override
    public int delete(Carousel carousel) throws SQLException {
        String sql = "delete from carousel where id=?,carDesc=?,imgpath=?,createtime=?";
        return executeUpdate(sql, carousel.getId(), carousel.getCardesc(), carousel.getImgpath(), carousel.getCreatetime());
    }


    @Override
    public Carousel upen(String id) throws SQLException {
        String sql = "select id,  `carDesc`,`imgpath`,`createtime` from carousel where  id =?";
        Carousel carousel;
        try {
            rs = executeQuery(sql, id);
            carousel = null;
            if (rs.next()) {
                carousel = new Carousel();
                carousel.setId(rs.getInt("id"));
                carousel.setCardesc(rs.getString("cardeac"));
                carousel.setImgpath(rs.getString("imgpath"));
                carousel.setCreatetime(rs.getString("createime"));

            }
        } finally {

            closeAll(conn, pstmt, rs);
        }

        return carousel;
    }

    @Override
    public List <Carousel> getUpen() throws SQLException {
        List <Carousel> carouselsList = new ArrayList <>(); //创建一个Carousel对象 List 集合，
        String sql = "select id,carDeac,imgpath ,createime form carousel"; //查询所有条信息
        try {


            Carousel carousel;
            rs = executeQuery(sql);
            carousel = null;

            while (rs.next()) {
                carousel = new Carousel();
                carousel.setId(rs.getInt("id"));
                carousel.setCardesc(rs.getString("cardear"));
                carousel.setImgpath(rs.getString("imgpath"));
                carousel.setCreatetime(rs.getString("createime"));  //查询到的每一条信息加入到carouselsList
                carouselsList.add(carousel);
            }
        } finally {
            closeAll(conn, pstmt, rs); //关闭资源
        }

        return carouselsList;  //返回这个集合数据
    }

    @Override
    public int getUserCount() {
        int count=0;
        String sql="SELECT COUNT(id) FROM carousel";

        try {
            rs= executeQuery(sql,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public List <Carousel> getCarouselList(int currentPage, int pageSize) throws SQLException {
        List<Carousel>carouselsList=new ArrayList<>();
        Carousel carousel;
       try {
        String sql="select id, carDesc, imgpath, createtime"
                + " from carousel limit ?,?";
        rs= executeQuery(sql,(currentPage-1)*pageSize,pageSize);
        carousel =null;
        while (rs.next()){
          carousel =new Carousel();
          carousel.setId(rs.getInt("id"));
          carousel.setCardesc(rs.getString("cardesc"));
          carousel.setImgpath(rs.getString("imgpath"));
          carousel.setCreatetime(rs.getString("createtime"));

        }
    }finally {
           closeAll(conn, pstmt, rs); //关闭资源
       }
        return carouselsList;
    }

}