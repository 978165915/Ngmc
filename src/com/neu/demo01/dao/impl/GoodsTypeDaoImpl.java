package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.GoodsTypeDao;
import com.neu.demo01.entity.GoodsType;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl extends DBUtil implements GoodsTypeDao {
    @Override
    public GoodsType getGoodsTypeById(int id) throws SQLException {
        String sql = "select id,typename from good_type where id = ?";
        rs =  executeQuery(sql,id);
        GoodsType goodsType = null;
        if(rs.next()){
            goodsType = new GoodsType();
            goodsType.setId(rs.getInt(1));
            goodsType.setTypename(rs.getString(2));
        }
        return goodsType;
    }
    //列表
    @Override
    public List<GoodsType> getGoodsTypeList() throws SQLException {
        List<GoodsType> goodsTypeList = new ArrayList<>();
        String sql = "select id,typename from good_type";
        rs =  executeQuery(sql);
        GoodsType goodsType = null;
        while(rs.next()){
            goodsType = new GoodsType();
            goodsType.setId(rs.getInt(1));
            goodsType.setTypename(rs.getString(2));
            goodsTypeList.add(goodsType);
        }
        return goodsTypeList;
    }
}
