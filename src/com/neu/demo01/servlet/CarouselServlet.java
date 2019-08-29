package com.neu.demo01.servlet;

import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.CarouselBiz;
import com.neu.demo01.biz.impl.CarouselBizImpl;
import com.neu.demo01.entity.Carousel;
import com.neu.demo01.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CarouselServlet ",urlPatterns = "/CarouselServlet")
public class CarouselServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String method = request.getParameter("method");
        PrintWriter out=response.getWriter(); //输出流
        CarouselBiz carouselbiz = new CarouselBizImpl(); //添加
        if (method.equals("lunbo")){
           String cardesc=  request.getParameter("carDesc");   //后台获取前台信息
           String price =request.getParameter("price");
           String  user=   request.getParameter("user");
           Carousel carousel =new Carousel(cardesc,price,user);
            try {
                if (carouselbiz.save(carousel)>0){
                    response.sendRedirect(request.getContextPath()+"/list.html");
                }else {
                    response.sendRedirect(request.getContextPath()+"/add.html");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }




        }
}
