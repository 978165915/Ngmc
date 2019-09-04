package com.neu.demo01.dao;

import com.neu.demo01.entity.GoodsType;

import java.sql.SQLException;
import java.util.List;

public interface GoodsTypeDao {
    GoodsType getGoodsTypeById(int id) throws SQLException;
    List<GoodsType> getGoodsTypeList() throws SQLException;
}
