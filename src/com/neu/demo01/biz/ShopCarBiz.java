package com.neu.demo01.biz;

import com.neu.demo01.entity.ShopCar;
import java.util.List;

public interface ShopCarBiz {
    int save(ShopCar shopCar);
    List<ShopCar> getShopCarList();
    int getShopCarCount();
    //修改购物车数量，num=1或-1
    int updateShopCar(int goodsId,int num);
}
