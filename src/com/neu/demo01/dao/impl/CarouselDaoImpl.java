package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.CarouselDao;
import com.neu.demo01.entity.Carousel;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarouselDaoImpl extends DBUtil implements CarouselDao {
    @Override
    public int save(Carousel carousel) throws SQLException {
        String sql= "insert into carousel(`id`,`carDesc`,`imgpath`,`createtime`) values ( ?, ?, ?, ?)";
        return executeUpdate(sql,carousel.getId(),carousel.getCardesc(),carousel.getImgpath(),carousel.getCreatetime());
    }

    @Override
    public int delete(Carousel carousel) throws SQLException {
       String sql="delete from carousel where id=?,carDesc=?,imgpath=?,createtime=?";
        return executeUpdate(sql,carousel.getId(),carousel.getCardesc(),carousel.getImgpath(),carousel.getCreatetime()) ;
    }



    @Override
    public Carousel upen(String id ) throws SQLException {
        String sql="select id,carDeac, imgpath,createime from caraouseel where  id =?";
        Carousel carousel;
        try {


        rs =  executeQuery(sql,id);
         carousel= null;
        if (rs.next()){
           carousel= new Carousel();
           carousel.setId(rs.getInt("id"));
           carousel.setCardesc(rs.getString("cardeac"));
           carousel.setImgpath(rs.getString("imgpath"));
           carousel.setCreatetime(rs.getString("createime"));

        }
        }finally {

            closeAll(conn, pstmt, rs);
        }

        return carousel ;
    }

    @Override
    public List<Carousel> getUpen() throws SQLException {
      List<Carousel>carouselsList = new ArrayList <>();
      String sql="select id,carDeac,imgpath,createime form caroudel";


        return null;
    }


}
