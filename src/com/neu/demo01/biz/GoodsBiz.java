package com.neu.demo01.biz;

import com.neu.demo01.entity.Goods;

import java.util.List;

public interface GoodsBiz {
  //新增
  int save(Goods goods);
  //修改
  int updateGoods(Goods goods);
  //删除
  int delGoodsById(int id);
    List<Goods> getGoodsList();
    List<Goods>getGoodsListByPage(int currentPage, int pageSize);
    int getGoodsCount();
}
