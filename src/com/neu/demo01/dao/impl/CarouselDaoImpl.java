package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.CarouselDao;
import com.neu.demo01.entity.Carousel;
import com.neu.demo01.entity.Goods;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarouselDaoImpl extends DBUtil implements CarouselDao {
    @Override
    public int save(Carousel carousel) throws SQLException {
        String sql= "insert into carousel(`carDesc`,`imgpath`,`createtime`,`categoryid`)"+
                "values(?,?,?,?)";
        return executeUpdate(sql, carousel.getCardesc(),carousel.getImgpath(),carousel.getCreatetime(),carousel.getCategoryid ());
    }

    @Override
    public int delete(Carousel carousel) throws SQLException {
        String sql="delete from carousel where id=?";
        return executeUpdate(sql,carousel.getId()) ;
    }





    @Override
    public Carousel upen(int id ) throws SQLException {
        String sql="select id,`carDesc`,`imgpath`,`createtime`,`categoryid` from `carousel` where  id =?";
        Carousel carousel;
        try {
            rs =  executeQuery (sql,id);
            carousel= null;
            if (rs.next()){
                carousel= new Carousel();
                carousel.setId (rs.getInt ("id"));
                carousel.setCardesc(rs.getString("cardesc"));
                carousel.setImgpath(rs.getString("imgpath"));
                carousel.setCreatetime(rs.getString("createtime"));
                carousel.setCategoryid (rs.getInt ("categoryid"));
            }
        }finally {

            closeAll(conn, pstmt, rs);
        }

        return carousel ;
    }

    @Override
    public List<Carousel> getUpen() throws SQLException {
        List<Carousel>carouselsList = new ArrayList <>(); //创建一个Carousel对象 List 集合，
        String sql="select id,carDeac,imgpath ,createtime ,`categoryid` form caroudel order by createtime"; //查询所有条信息
        try {


            Carousel carousel;
            rs=executeQuery (sql);
            carousel=null;

            while (rs.next()){
                carousel=new Carousel();
                carousel.setId(rs.getInt("id"));
                carousel.setCardesc(rs.getString("cardear"));
                carousel.setImgpath(rs.getString("imgpath"));
                carousel.setCreatetime(rs.getString("createtime"));//查询到的每一条信息加入到carouselsList
                carousel.setCategoryid (rs.getInt ("categoryid"));
                carouselsList.add(carousel);
            }
        }finally {
            closeAll(conn, pstmt, rs); //关闭资源
        }

        return carouselsList;  //返回这个集合数据
    }

    @Override
    public List <Carousel> getCarouselListByPage( int currentPage, int pageSize ) throws SQLException {
        List<Carousel>carouselList=new ArrayList <> ();
        String sql="select `id`,`carDesc`,`imgpath`,`createtime`,`categoryid`"
                +"from carousel order by createtime limit ?,?";
        try {


            rs = executeQuery (sql, (currentPage - 1) * pageSize, pageSize);
            Carousel carousel = null;
            while (rs.next ( )) {
                carousel = new Carousel ( );
                carousel.setId (rs.getInt ("id"));
                carousel.setCardesc (rs.getString ("cardesc"));
                carousel.setImgpath (rs.getString ("imgpath"));
                carousel.setCreatetime (rs.getString ("createtime"));
                carousel.setCategoryid (rs.getInt ("categoryid"));
                carouselList.add (carousel);
            }
        }finally {
            closeAll(conn, pstmt, rs);
        }
        return carouselList;
    }

    @Override
    public int getCarouselsCount() throws SQLException {
        int count=0;
        String sql="SELECT COUNT(id) FROM carousel";  //查询多少条页数
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



    @Override  //新增
    public int update( Carousel carousel ) throws SQLException {
        String sql ="UPDATE `carousel` SET  carDesc=?,imgpath=?,categoryid=? WHERE id=?";
        return executeUpdate (sql,carousel.getCardesc (),carousel.getImgpath (),carousel.getCategoryid (),carousel.getId ());
    }


}
