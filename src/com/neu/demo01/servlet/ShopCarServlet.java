package com.neu.demo01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    ShopCarBiz shopCarbiz = new ShopCarBizImpl();
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
        if (method.equals("shopCarList")){
            List<ShopCar> shopCarsList=shopCarbiz.getShopCarList();
            String userListJSON=JSON.toJSONStringWithDateFormat(shopCarsList,"yyyy-MM-dd HH:mm:ss");
            out.print(userListJSON);
        }else if(method.equals("saveOrUpdate")){
            String goodsId = request.getParameter("goodsId");
            if(goodsId!=null&&!goodsId.equals("")) {
                Map<Integer, ShopCar> shopCarMap = (Map<Integer, ShopCar>) session.getAttribute("shopCarMap");
                if(shopCarMap.containsKey(Integer.parseInt(goodsId))) {//如果有此商品，就修改数量
                        int num = Integer.parseInt(request.getParameter("c_num"));
                    if (shopCarbiz.updateShopCar(Integer.parseInt(goodsId),num)>0){
                        loadShopCarList(session);
                        out.print("update_success");
                    }
                }else {//如果没有此商品，就新增一条
                    String create_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//创建时间
                    ShopCar shopCar = new ShopCar(Integer.parseInt(goodsId),1,1,create_date);
                    if (shopCarbiz.save(shopCar)>0){
                        loadShopCarList(session);
                        out.print("add_success");
                    }
                }
            }
        }else if(method.equals("carNum")){
            loadShopCarList(session);
            out.print(shopCarbiz.getShopCarCount());
        }

    }
    private void loadShopCarList(HttpSession session){
        Map<Integer,ShopCar> shopCarMap = new HashMap<>();
        List<ShopCar> shopCarsList=shopCarbiz.getShopCarList();
        for (ShopCar shopCar:shopCarsList){
            shopCarMap.put(shopCar.getGoods_id(),shopCar);
        }
        session.setAttribute("shopCarMap",shopCarMap);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
