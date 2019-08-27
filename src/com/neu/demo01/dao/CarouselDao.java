package com.neu.demo01.dao;

import com.neu.demo01.entity.Carousel;
import com.neu.demo01.entity.User;

import java.sql.SQLException;

public interface CarouselDao {
     //新增一个轮播对象
    int save(Carousel carousel) throws SQLException;
    //删除一个对象
    int delete(Carousel carousel) throws  SQLException;
    //根据用户名查询一条记录
    Carousel getCarouselByid(int id) throws  SQLException;

}