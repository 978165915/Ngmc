package com.neu.demo01.entity;

public class Goods {
    private int id;
    private String name;
    private int typeid;
    private String imgpath;
    private String price;
    private String goodsDesc;
    private String createTime;
    public Goods() {
    }

    public Goods(int i, String name, int typeid, String imgpath, String price, String goodsDesc, String createTime) {
        this.id=id;
        this.name = name;
        this.typeid = typeid;
        this.imgpath = imgpath;
        this.price = price;
        this.goodsDesc = goodsDesc;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
