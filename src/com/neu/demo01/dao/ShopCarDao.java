package com.neu.demo01.dao;

import com.neu.demo01.entity.ShopCar;

import java.sql.SQLException;
import java.util.List;

public interface ShopCarDao {
    int save(ShopCar shopCar) throws SQLException;
    //根据用户ID获得购物车
    List<ShopCar> getShopCarList() throws SQLException;
    int getShopCarCount() throws SQLException;
    //修改购物车数量，num=1或-1
    int updateShopCar(int goodsId,int num)throws SQLException;
}
