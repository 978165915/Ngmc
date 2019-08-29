package com.neu.demo01.entity;

public class Carousel {

    private int id;
    private String cardesc;
    private String imgpath;
    private String createtime;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardesc() {
        return cardesc;
    }

    public void setCardesc(String cardesc) {
        this.cardesc = cardesc;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Carousel( String cardesc, String imgpath, String createtime) {
        this.cardesc = cardesc;
        this.imgpath = imgpath;
        this.createtime = createtime;
    }
    public Carousel(){

    }

}
