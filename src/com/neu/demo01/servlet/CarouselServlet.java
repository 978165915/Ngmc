package com.neu.demo01.servlet;


import com.neu.demo01.biz.CarouselBiz;
import com.neu.demo01.biz.impl.CarouselBizImpl;
import com.neu.demo01.entity.Carousel;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CarouselServlet")
public class CarouselServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        CarouselBiz carouselbiz = new CarouselBizImpl(); //添加
        PrintWriter out=response.getWriter();
        if (method.equals("lunbo")) {
            String cardesc = request.getParameter("carDesc");   //后台获取前台信息
            String price = request.getParameter("price");
            String user = request.getParameter("user");
            Carousel carousel = new Carousel(cardesc, price, user); //把后台获到的信息付给Carousel
            if (carouselbiz.save(carousel) > 0) {     //添加成功时
                session.setAttribute("carousel",carousel);
                session.setMaxInactiveInterval(5*60);
                response.sendRedirect(request.getContextPath()+"/list.html");


            }else {
                response.sendRedirect(request.getContextPath()+"/list.html");
            }


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}