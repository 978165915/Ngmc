package com.neu.demo01.dao;

import com.neu.demo01.entity.Carousel;
import com.neu.demo01.entity.Goods;
import com.neu.demo01.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CarouselDao {
    //新增一个轮播对象
    int save(Carousel carousel) throws SQLException;
    //删除一个对象
    int delete(Carousel carousel) throws  SQLException;
    //根据用户名查询一条记录
    Carousel upen( int id) throws SQLException;
    //   //查询多条信息
    List<Carousel> getUpen() throws SQLException;
    List<Carousel>getCarouselListByPage( int currentPage, int pageSize) throws SQLException; //页数
    int getCarouselsCount() throws SQLException; //查询多少条记录
    public int update(Carousel carousels) throws SQLException; //新增


}
