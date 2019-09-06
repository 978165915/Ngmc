package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.ShopCarDao;
import com.neu.demo01.entity.ShopCar;
import com.neu.demo01.entity.User;
import com.neu.demo01.util.DBUtil;
import com.neu.demo01.util.MD5;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopCarDaoImpl extends DBUtil implements ShopCarDao{
    @Override
    public int save(ShopCar shopCar) throws SQLException {
        String sql="insert into shopping_car(id, goods_id, num, userid, create_date) " +
                "values ( ?, ?, ?, ?, ?)";
        return executeUpdate(sql,shopCar.getId(),shopCar.getGoods_id(),shopCar.getNum(),shopCar.getUser_id(),
                shopCar.getCreate_date());
    }



    @Override
    public List<ShopCar> getShopCarList() throws SQLException {
        List<ShopCar>shopCarList=new ArrayList<>();
        String sql="SELECT sc.id, sc.goods_id, sc.num, sc.userid,sc.create_date," +
                "g.`name`,g.`imgpath` ,g.`price`" +
                " FROM shopping_car sc,goods g" +
                " WHERE sc.`goods_id`=g.id";
        ShopCar shopCar;
        try {
            rs = executeQuery(sql);
            shopCar = null;
            while (rs.next()) {
                shopCar = new ShopCar();
                shopCar.setId(rs.getInt("id"));
                shopCar.setGoods_id(rs.getInt("goods_id"));
                shopCar.setNum(rs.getInt("num"));;
                shopCar.setUser_id(rs.getInt("userid"));
                shopCar.setCreate_date(rs.getString("create_date"));
                shopCar.setName(rs.getString("name"));
                shopCar.setPrice(rs.getDouble("price"));
                shopCar.setImgpach(rs.getString("imgpath"));
                shopCarList.add(shopCar);
            }
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return shopCarList;
    }

    @Override
    public int getShopCarCount() throws SQLException {
        int count=0;
        String sql="SELECT COUNT(num) FROM shopping_car";
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

    @Override
    public int updateShopCar(int goodsId, int num) throws SQLException {
        String sql = "UPDATE `shopping_car` " +
                "SET num = num +(?) " +
                "WHERE  goods_id= ?";
        return executeUpdate(sql,num,goodsId);
    }


}
