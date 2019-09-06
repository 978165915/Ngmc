package com.neu.demo01.servlet;

import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.OrderBiz;
import com.neu.demo01.biz.OrderDetailBiz;
import com.neu.demo01.biz.impl.OrderBizImpl;
import com.neu.demo01.biz.impl.OrderDetailBizImpl;
import com.neu.demo01.entity.Order;
import com.neu.demo01.entity.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        OrderDetailBiz orderDetailBiz= new OrderDetailBizImpl();
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
                    "  \"count\": "+orderbiz.getOrderCount()+"," +//总行数
                    "  \"data\":"//表格数据
            );
            String orderListJSON=JSON.toJSONStringWithDateFormat(orderList,"yyyy-MM-dd HH:mm:ss");
            sb.append(orderListJSON);//拼接对象数组
            sb.append("}");
            out.print(sb.toString());
        }else if(method.equals("orderList")){
            List<Order> orderList = orderbiz.getOrderList();
            String orderListJSON = JSON.toJSONStringWithDateFormat(orderList,"yyyy-MM-dd HH:mm:ss");
            out.print(orderListJSON);
        }else if (method.equals("saveOrder")){
           /* List<Order> orderList = orderbiz.getOrderList();
            String orderListJSON = JSON.toJSONString(orderList);
            out.print(orderListJSON);*/
          int orderId = request.getParameter ("orderId")==null?0:Integer.parseInt(request.getParameter("orderId"));
            String userId=request.getParameter("userId");
            double total=request.getParameter("total")==null?0:Integer.parseInt(request.getParameter("total"));
            int payType=request.getParameter("payType")==null?0:Integer.parseInt(request.getParameter("payType"));
            int status=request.getParameter("status")==null?0:Integer.parseInt(request.getParameter("status"));
            String shipCode=request.getParameter("shipCode");
            String shipName=request.getParameter("shipName");
            Date date=new Date();
            String createTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            String closeTime=request.getParameter("closeTime");
            Order order= new Order(orderId,userId,total,payType,status,shipName,shipCode,createTime,closeTime);
            if (orderbiz.saveOrder(order)>0){
                out.print("添加成功");
            }
        }else if (method.equals("saveOrderItem")){
            int itemid = request.getParameter ("orderId")==null?0:Integer.parseInt(request.getParameter("orderid"));
            int orderid = request.getParameter ("orderId")==null?0:Integer.parseInt(request.getParameter("orderid"));
            double price=request.getParameter("payType")==null?0:Integer.parseInt(request.getParameter("price"));
            int num=request.getParameter("status")==null?0:Integer.parseInt(request.getParameter("num"));
            double total=request.getParameter("total")==null?0:Integer.parseInt(request.getParameter("total"));
            OrderItem orderItem=new OrderItem(itemid,orderid,price,num,total);
            if (orderDetailBiz.saveOrderItem(orderItem)>0){
                out.print("添加成功");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
