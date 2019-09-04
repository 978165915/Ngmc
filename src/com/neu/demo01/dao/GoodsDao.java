package com.neu.demo01.dao;

import com.neu.demo01.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    //新增商品
    int save(Goods goods)throws SQLException;
    //修改商品信息
    int update(Goods goods,int id)throws Exception;
    //删除商品
    int delGoodsById(int id)throws Exception;
    //查询一条
    Goods GoodsList(int id)throws Exception;
    //组合查询获取商品列表
    List<Goods> getGoodsList() throws SQLException;
    List<Goods>getGoodsListByPage(int currentPage,int pageSize) throws SQLException;
    //查詢商品個數
    int getGoodsCount() throws SQLException;
}
