package com.neu.demo01.biz;

import com.neu.demo01.entity.Carousel;

import java.util.List;

public interface CarouselBiz {
    //删除一个对象
    int delete(Carousel carousel);
    //根据用户名查询一条记录
    Carousel upen( String id);
    //查询多条信息
    List<Carousel> getUpen();
    List <Carousel> getCarouselU (int currentPage, int pageSize);
    int getUserCount();

}
