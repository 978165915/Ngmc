package com.neu.demo01.servlet;

import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.GoodsBiz;
import com.neu.demo01.biz.impl.GoodsBizImpl;
import com.neu.demo01.entity.Goods;

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

@WebServlet("/GoodsServlet/*")
public class GoodsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GoodsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String method = request.getParameter("method");
        PrintWriter out=response.getWriter();
        GoodsBiz goodsBiz=new GoodsBizImpl();
        if (method.equals("save")){//新增
            String name=request.getParameter("name");
            String typeid=request.getParameter("typeid");
            String imgpath=request.getParameter("imgpath");
            String price=request.getParameter("price");
            String goodsDesc=request.getParameter("goodsDesc");
            Date date=new Date();
            String createTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            //String createTime=查询  获取java系统时间 格式
            Goods goods=new Goods(name,Integer.parseInt(typeid),imgpath,price,goodsDesc, createTime);
            if (goodsBiz.save(goods)>0){//新增成功
                response.sendRedirect(request.getContextPath()+"pages/goods/list.html");
            }else{//新增失败
                response.sendRedirect(request.getContextPath()+"pages/goods/add.html");
            }
        }else if(method.equals("goodsList")){
            //获得页面当前页码page,
            int page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            //获得页面页大小limit
            int limit=request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
            List<Goods> goodsList=goodsBiz.getGoodsListByPage(page,limit);
            StringBuilder sb = new StringBuilder("");
            sb.append("{" +
                    "  \"code\": 0," +
                    "  \"msg\": \"\"," +
                    "  \"count\": "+goodsBiz.getGoodsCount()+"," +
                    "  \"data\":");
            String goodsListJSON=JSON.toJSONStringWithDateFormat(goodsList,"yyyy-MM-dd HH:mm:ss");
            sb.append(goodsListJSON);//拼接对象数组
            sb.append("}");
            out.print(sb.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
