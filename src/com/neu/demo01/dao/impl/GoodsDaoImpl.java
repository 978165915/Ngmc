package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.GoodsDao;
import com.neu.demo01.entity.Goods;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends DBUtil implements GoodsDao {
    @Override
    public int save(Goods goods) throws SQLException {
        String sql="insert into goods(`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`)"+
                "values(?,?,?,?,?,?)";
        return executeUpdate(sql,goods.getName(),goods.getTypeid(),goods.getImgpath(),goods.getPrice(),goods.getGoodsDesc(),goods.getCreateTime());
    }

    @Override
    public int updateGoods(Goods goods) throws Exception {
        String sql="UPDATE `goods` " +
                " SET `id`=?," +
                "`name`=?," +
                "`typeid`=?," +
                "`imgpath`=?," +
                "`price`=?" +
                "`goodsDesc`=?" +
                "`createTime`=?" +
                " WHERE `id`=?" ;
        return executeUpdate(sql,goods.getId(),goods.getName(),goods.getTypeid(),goods.getImgpath(),goods.getPrice(),goods.getGoodsDesc(),goods.getCreateTime());
    }

    @Override
    public int delGoodsById(int id) throws Exception {
        String sql="update goods set state=0 where id=?";
        return executeUpdate(sql, id);
    }

    @Override
    public List<Goods> getGoodsList() throws SQLException {
        List<Goods>goodsList=new ArrayList<>();
        String sql="select `id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`"
                +"from Goods";
        try {
            rs = executeQuery(sql);
            Goods goods = null;
            while (rs.next()) {
                goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setTypeid(rs.getInt("typeid"));
                goods.setImgpath(rs.getString("imgpath"));
                goods.setPrice(rs.getString("price"));
                goods.setGoodsDesc(rs.getString("goodsDesc"));
                goods.setCreateTime(rs.getString("createTime"));
                goodsList.add(goods);
            }
        }finally {
            closeAll(conn, pstmt, rs);
        }
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsListByPage(int currentPage, int pageSize)  throws SQLException{
        List<Goods>goodsList=new ArrayList<>();
        String sql="select `id`,`name`,`typeid`,`imgpath`,`price`,`goodsDesc`,`createTime`"
                +"from Goods order by createTime desc limit ?,?";
        try {
            rs = executeQuery(sql,(currentPage-1)*pageSize,pageSize);
            Goods goods = null;
            while (rs.next()) {
                goods = new Goods();
                goods.setId(rs.getInt("id"));
                goods.setName(rs.getString("name"));
                goods.setTypeid(rs.getInt("typeid"));
                goods.setImgpath(rs.getString("imgpath"));
                goods.setPrice(rs.getString("price"));
                goods.setGoodsDesc(rs.getString("goodsDesc"));
                goods.setCreateTime(rs.getString("createTime"));
                goodsList.add(goods);
            }
        }finally {
            closeAll(conn, pstmt, rs);
        }
        return goodsList;
    }

    @Override
    public int getGoodsCount() throws SQLException {
        int count=0;
        String sql="SELECT COUNT(id) FROM goods";
        try{
            rs=executeQuery(sql,null);
            if(rs.next()){
                count=rs.getInt(1);
            }
        }finally {
            closeAll(conn,pstmt,rs);
        }
        return count;
    }

}
