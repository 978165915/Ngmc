package com.neu.demo01.entity;
/*`goods_id` int (11),
        `num` int (5),
        `userid` int (11),
        `create_date` varchar (19)*/
public class ShopCar {
    private int id;//购物车ID
    private int goods_id;//商品ID
    private int num;//购买数量
    private int user_id;//用户ID
    private String create_date;//创建时间
    private String name;//商品名，
    private String imgpach;//商品图片
    private double price;//，商品价格，
//
    public ShopCar(){};

    public ShopCar(int id, int goods_id, int num, int user_id, String create_date, String name,String imgpach,double price){
        this.id = id;
        this.goods_id = goods_id;
        this.num = num;
        this.user_id = user_id;
        this.create_date = create_date;
        this.name = name;
        this.imgpach = imgpach;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getGoods_id(){return goods_id;}
    public void setGoods_id(int goods_id){ this.goods_id = goods_id;}

    public int getNum(){ return num;}
    public void setNum(int num){ this.num = num;}


    public int getUser_id(){ return user_id;}
    public void setUser_id(int user_id){ this.user_id=user_id;}

    public String getCreate_date(){return create_date;}
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
    }

    public String getImgpach() {
        return imgpach;
    }

    public void setImgpach(String imgpach) {
        this.imgpach = imgpach;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
