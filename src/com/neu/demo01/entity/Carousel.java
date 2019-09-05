package com.neu.demo01.entity;

public class Carousel {

    private int id; //编号
    private String cardesc;//轮播图广告描述
    private String imgpath;//轮播图路径
    private String createtime;//用户创建时间
    private int categoryid; //别编号
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getCardesc() {
        return cardesc;
    }

    public void setCardesc( String cardesc ) {
        this.cardesc = cardesc;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath( String imgpath ) {
        this.imgpath = imgpath;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime( String createtime ) {
        this.createtime = createtime;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid( int categoryid ) {
        this.categoryid = categoryid;
    }

    public Carousel(  String cardesc, String imgpath, String createtime, int categoryid ) {
        this.cardesc = cardesc;
        this.imgpath = imgpath;
        this.createtime = createtime;
        this.categoryid = categoryid;
    }

    public Carousel() {

    }
}
