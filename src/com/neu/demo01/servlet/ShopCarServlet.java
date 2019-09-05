package com.neu.demo01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.ShopCarBiz;
import com.neu.demo01.biz.impl.ShopCarBizImpl;
import com.neu.demo01.entity.ShopCar;
import com.neu.demo01.entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(  name="ShopCar",urlPatterns = "/ShopCarServlet")
public class ShopCarServlet extends HttpServlet {
     static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String method = request.getParameter("method");
        PrintWriter out=response.getWriter();
        ShopCarBiz shopCarbiz = new ShopCarBizImpl();
        if (method.equals("userList")){
            List<ShopCar> shopCarsList=shopCarbiz.getShopCarList();
            String userListJSON=JSON.toJSONStringWithDateFormat(shopCarsList,"yyyy-MM-dd HH:mm:ss");
            out.print(userListJSON);
        }else if(method.equals("save")){
             int goods_id=request.getParameter("goods_id")==null?0:Integer.parseInt(request.getParameter("goods_id"));//商品ID
             int num=request.getParameter("num")==null?0:Integer.parseInt(request.getParameter("num"));//购买数量
             int user_id=request.getParameter("user_id")==null?0:Integer.parseInt(request.getParameter("user_id"));//用户ID
             String create_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//创建时间
            ShopCar shopCar = new ShopCar(goods_id,num,user_id,create_date);
            if (shopCarbiz.save(shopCar)>0){
                out.print("success");
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
