package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.CarouselDao;
import com.neu.demo01.entity.Carousel;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;

public class CarouselDaoImpl extends DBUtil implements CarouselDao {
    @Override
    public int save(Carousel carousel) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Carousel carousel) throws SQLException {
        return 0;
    }

    @Override
    public Carousel getCarouselByid(int id) throws SQLException {
        return null;
    }
}
