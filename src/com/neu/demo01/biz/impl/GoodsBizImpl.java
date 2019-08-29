package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.GoodsBiz;
import com.neu.demo01.dao.impl.GoodsDaoImpl;
import com.neu.demo01.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public class GoodsBizImpl implements GoodsBiz {


    @Override
    public int save(Goods goods) {
        try {
            return new GoodsDaoImpl().save(goods);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Goods> getGoodsList() {
        try {
            return new GoodsDaoImpl().getGoodsList();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Goods> getGoodsListByPage(int currentPage, int pageSize) {
        try {
            return new GoodsDaoImpl().getGoodsListByPage(currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getGoodsCount() {
        try {
            return new GoodsDaoImpl().getGoodsCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
