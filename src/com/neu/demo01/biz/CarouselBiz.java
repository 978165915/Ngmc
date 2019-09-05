package com.neu.demo01.biz;

import com.neu.demo01.entity.Carousel;
import java.util.List;

public interface CarouselBiz {
    //新增一个轮播对象
    int save(Carousel carousel) ;
    //删除一个对象
    int delete(int id);
    //根据用户名查询一条记录
    Carousel upen( int id);
    //查询多条信息
    List<Carousel> getUpen();
    // //获取页码数
    List<Carousel>getCarouselListByPage( int currentPage, int pageSize) ;
    int getCarouselsCount() ; //获取多少条数据记录
    //修改用户
    public int update(Carousel carousel);

}