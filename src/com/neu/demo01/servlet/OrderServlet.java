package com.neu.demo01.servlet;

import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.OrderBiz;
import com.neu.demo01.biz.impl.OrderBizImpl;
import com.neu.demo01.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet( "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String method = request.getParameter("method");
        PrintWriter out=response.getWriter();
        OrderBiz orderbiz= new OrderBizImpl();
        if (method.equals("orderListLayui")){//连接列表
            //获得页面当前页码
            int page = request.getParameter ("page") == null ? 1 : Integer.parseInt (request.getParameter ("page"));
            //获得页面页大小limit
            int limit = request.getParameter ("limit") == null ? 1 : Integer.parseInt (request.getParameter ("limit"));
            List<Order> orderList = orderbiz.getOrderListByPage(page,limit);
            StringBuilder sb = new StringBuilder("");
            sb.append("{" +
                    "  \"code\": 0," +
                    "  \"msg\": \"\"," +
                    "  \"count\": "+orderbiz.getOrderCount()+"," +
                    "  \"data\":"
            );
            String orderListJSON=JSON.toJSONStringWithDateFormat(orderList,"yyyy-MM-dd HH:mm:ss");
            sb.append(orderListJSON);//拼接对象数组
            sb.append("}");
            out.print(sb.toString());
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
