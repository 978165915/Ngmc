package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.GoodsTypeBiz;
import com.neu.demo01.dao.impl.GoodsTypeDaoImpl;
import com.neu.demo01.entity.GoodsType;

import java.sql.SQLException;
import java.util.List;

public class GoodsTypeBizImpl implements GoodsTypeBiz {
    @Override
    public GoodsType getGoodsTypeById(int id)  {
        try {
            return new GoodsTypeDaoImpl().getGoodsTypeById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GoodsType> getGoodsTypeList()  {
        try {
            return new GoodsTypeDaoImpl().getGoodsTypeList();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
