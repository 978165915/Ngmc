package com.neu.demo01.biz;

import com.neu.demo01.entity.GoodsType;

import java.sql.SQLException;
import java.util.List;

public interface GoodsTypeBiz {
    GoodsType getGoodsTypeById(int id);
    List<GoodsType> getGoodsTypeList();
}
