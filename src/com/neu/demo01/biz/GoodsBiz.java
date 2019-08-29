package com.neu.demo01.biz;

import com.neu.demo01.entity.Goods;

import java.util.List;

public interface GoodsBiz {
  int save(Goods goods);
    List<Goods> getGoodsList();
    List<Goods>getGoodsListByPage(int currentPage, int pageSize);
    int getGoodsCount();
}
