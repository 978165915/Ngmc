package com.neu.demo01.biz;

import com.neu.demo01.entity.Carousel;

import java.sql.SQLException;
import java.util.List;

public interface CarouselBiz {
    //新增一个轮播对象
    int save(Carousel carousel) ;
    //删除一个对象
    int delete(Carousel carousels);
    //根据用户名查询一条记录
    Carousel upen( String id);
    //查询多条信息
    List<Carousel> getUpen();
    //获取页码数
    List<Carousel>getCarouselListByPage( int currentPage, int pageSize) ;
    int getCarouselsCount() ; //获取多少条数据记录



}
