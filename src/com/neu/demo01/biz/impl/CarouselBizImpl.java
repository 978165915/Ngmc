package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.CarouselBiz;
import com.neu.demo01.dao.impl.CarouselDaoImpl;
import com.neu.demo01.entity.Carousel;

import java.sql.SQLException;
import java.util.List;

public class CarouselBizImpl  implements CarouselBiz {
    @Override  //增加
    public int save(Carousel carousels)  {
        try {
            return new CarouselDaoImpl().save(carousels);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }




    @Override   //删除
    public int delete(Carousel carousel)  {
        try {
            return new CarouselDaoImpl().delete(carousel);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override     //查询一条
    public Carousel upen(String id) {
        try {
            return new  CarouselDaoImpl().upen(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override   //查询多条
    public List<Carousel> getUpen() {
        try {
            return new CarouselDaoImpl().getUpen();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override  //页码数
    public List <Carousel> getCarouselListByPage( int currentPage, int pageSize ) throws SQLException {
       try {
           return new CarouselDaoImpl ().getCarouselListByPage (currentPage,pageSize);

    }catch (SQLException e ){
           e.printStackTrace();
       }
       return null;
    }

    @Override
    public int getCarouselsCount() throws SQLException {
       try {
           return new CarouselDaoImpl ().getCarouselsCount ();

       }catch (SQLException e){
           e.printStackTrace ();
       }
        return 0;



    }
}
