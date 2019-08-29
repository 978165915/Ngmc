package com.neu.demo01.servlet;

import com.alibaba.fastjson.JSON;
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
        PrintWriter out=response.getWriter();
        CarouselBiz carouselbiz = new CarouselBizImpl();
        if (method.equals("carouseList")){
            int page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            //获得页面页大小limit
            int limit=request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
            List <Carousel> userList=carouselbiz.getCarouselU(page,limit);
            StringBuilder bs = new StringBuilder("");
            bs.append("{" +
                    "  \"code\": 0," +
                    "  \"msg\": \"\"," +
                    "  \"count\": "+"," +
                    "  \"data\":");   //拼接字符串
            String userListJSON=JSON.toJSONStringWithDateFormat(userList,"yyyy-MM-dd HH:mm:ss");
            bs.append(userListJSON);//拼接对象数组
            bs.append("}");
            out.print(bs.toString());

        }else if (method.equals("lunbo")){
          String cardesc = request.getParameter("carDesc");
          String price =   request.getParameter("price");
          String  user =  request.getParameter("user");


        }


        }
}
