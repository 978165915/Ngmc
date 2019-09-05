package com.neu.demo01.servlet;


import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.CarouselBiz;
import com.neu.demo01.biz.impl.CarouselBizImpl;
import com.neu.demo01.entity.Carousel;
import com.neu.demo01.entity.Goods;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.applet.Applet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/CarouselServlet")
public class CarouselServlet extends HttpServlet {

    protected void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter ("method");
        request.setCharacterEncoding ("utf-8");
        response.setCharacterEncoding ("utf-8");
        response.setContentType ("text/html;charset=utf-8");
        HttpSession session = request.getSession ( );
        CarouselBiz carouselbiz = new CarouselBizImpl ( ); //添加
        PrintWriter out = response.getWriter ( );
        if (method.equals ("carouselList")) { //连接列表
                //获得页面当前页码page,
                int page = request.getParameter ("page") == null ? 1 : Integer.parseInt (request.getParameter ("page"));
                //获得页面页大小limit
                int limit = request.getParameter ("limit") == null ? 1 : Integer.parseInt (request.getParameter ("limit"));
                List<Carousel>carouselsList= carouselbiz.getCarouselListByPage (page,limit);
                StringBuilder sb = new StringBuilder("");
                sb.append("{" +
                        "  \"code\": 0," +
                        "  \"msg\": \"\"," +
                        "  \"count\": "+carouselbiz.getCarouselsCount ()+"," +
                        "  \"data\":");
                String goodsListJSON=JSON.toJSONStringWithDateFormat(carouselsList,"yyyy-MM-dd HH:mm:ss");
                sb.append(goodsListJSON);//拼接对象数组
                sb.append("}");
                out.print(sb.toString());

            } else if (method.equals ("seve")) {  //新增的
            String cardesc = request.getParameter ("cardesc");
            String imgpath = request.getParameter ("imgpath");
            Date date = new Date ( );
                String createTime = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format (date);
                String categoryid = request.getParameter ("categoryid"); //页面请求过来的数据
                Carousel carousel = new Carousel ( cardesc, imgpath, createTime, Integer.parseInt (categoryid));

                if (carouselbiz.save (carousel) > 0) { //新增个用户
                    out.print (1);
                }

            } else if (method.equals ("update")){
            String da =request.getParameter ("dataId");
            String cardesc = request.getParameter ("cardesc");
            String imgpath = request.getParameter ("imgpath");
            String categoryid = request.getParameter ("categoryid"); //页面请求过来的数据
            Carousel carousel = new Carousel ();
            carousel.setCategoryid (Integer.parseInt(categoryid));
            carousel.setImgpath (imgpath);
            carousel.setCardesc (cardesc);
            carousel.setId (Integer.parseInt(da));
            int a = carouselbiz.update (carousel);
            if (a>0){
                out.print (1);
            }
        } else if (method.equals ("shwo")){//查询一条记录
                String dataId  = request.getParameter ("id");
                Carousel carousel= carouselbiz.upen (Integer.parseInt (dataId) );
                String  carouselJSON=JSON.toJSONStringWithDateFormat (carousel,"yyyy-MM-dd");
                out.print (carouselJSON);
        }

        }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}