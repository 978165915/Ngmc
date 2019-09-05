package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.ShopCarBiz;
import com.neu.demo01.dao.impl.ShopCarDaoImpl;
import com.neu.demo01.entity.ShopCar;

import java.sql.SQLException;
import java.util.List;

public class ShopCarBizImpl implements ShopCarBiz {
    @Override
    public int save(ShopCar shopCar) {
        try {
            return new ShopCarDaoImpl().save(shopCar);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }



    @Override
    public List<ShopCar> getShopCarList() {
        try {
            return new ShopCarDaoImpl().getShopCarList();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getShopCarCount() {
        try {
            return new ShopCarDaoImpl().getShopCarCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
