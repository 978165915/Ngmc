package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.CarouselBiz;
import com.neu.demo01.dao.impl.CarouselDaoImpl;
import com.neu.demo01.dao.impl.GoodsDaoImpl;
import com.neu.demo01.dao.impl.GoodsTypeDaoImpl;
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
    public int delete(int id)  {
        try {
            return new CarouselDaoImpl().delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override     //查询一条
    public Carousel upen(int id) {
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
    public List <Carousel> getCarouselListByPage( int currentPage, int pageSize ) {
        try {
            List<Carousel> carouselList=new CarouselDaoImpl ().getCarouselListByPage (currentPage,pageSize);
            for (int i=0;i<carouselList.size ();i++){
                Carousel carousel=carouselList.get (i);
                carousel.setGoodsType (new GoodsTypeDaoImpl ().getGoodsTypeById (carousel.getCategoryid ()));
            }
            return carouselList;

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCarouselsCount() {
        try {
            return new CarouselDaoImpl ().getCarouselsCount ();

        }catch (SQLException e){
            e.printStackTrace ();
        }
        return 0;



    }

    @Override     //修改
    public int update( Carousel carousels  ) {
        try {

            return new CarouselDaoImpl ().update (carousels);
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
        return 0;
    }
}
