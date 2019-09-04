package com.neu.demo01.servlet;

import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.GoodsTypeBiz;
import com.neu.demo01.biz.impl.GoodsTypeBizImpl;
import com.neu.demo01.entity.GoodsType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GoodsTypeServlet")
public class GoodsTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String method = request.getParameter("method");
        PrintWriter out=response.getWriter();
        GoodsTypeBiz goodsTypeBiz = new GoodsTypeBizImpl();
        if (method.equals("typeList")) {//新增
            List<GoodsType> goodsTypeList = goodsTypeBiz.getGoodsTypeList();
            String goodsTypeListJSON = JSON.toJSONString(goodsTypeList);
            out.print(goodsTypeListJSON);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
