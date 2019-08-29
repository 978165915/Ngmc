package com.neu.demo01.dao;

import com.neu.demo01.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    int save(Goods goods)throws SQLException;
    List<Goods> getGoodsList() throws SQLException;
    List<Goods>getGoodsListByPage(int currentPage,int pageSize) throws SQLException;
    int getGoodsCount() throws SQLException;
}
