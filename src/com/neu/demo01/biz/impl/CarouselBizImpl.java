package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.CarouselBiz;
import com.neu.demo01.dao.impl.CarouselDaoImpl;
import com.neu.demo01.entity.Carousel;

import java.sql.SQLException;
import java.util.List;

public class CarouselBizImpl  implements CarouselBiz {

    @Override
    public int delete(Carousel carousel) {
        try {
            return new CarouselDaoImpl().delete(carousel);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Carousel upen(String id) {
        try {
            return new  CarouselDaoImpl().upen(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<Carousel> getUpen() {
        try {
            return new CarouselDaoImpl().getUpen();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public int getUserCount() {
        return new CarouselDaoImpl().getUserCount();
    }

    @Override
    public List <Carousel> getCarouselU(int currentPage, int pageSize) {
        try {
            return new  CarouselDaoImpl().getCarouselList(currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
