package com.neu.demo01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.neu.demo01.biz.UserBiz;
import com.neu.demo01.biz.impl.UserBizImpl;
import com.neu.demo01.entity.PageBean;
import com.neu.demo01.entity.User;
import jdk.nashorn.internal.objects.NativeJSON;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(  name="User",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		UserBiz userbiz = new UserBizImpl();
		if(method.equals("login")) {//执行登录
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			User user =	userbiz.login(userName,password);
			if(user!=null) {//登录成功
				session.setAttribute("user",user);
				session.setMaxInactiveInterval(5*60);
				response.sendRedirect(request.getContextPath()+"/index.html");
			}else {//登录失败
				response.sendRedirect(request.getContextPath()+"/login.html");
			}
		}else if(method.equals("register")) {
			//执行注册
			String  username =request.getParameter("username");
			String pwd =request.getParameter("password");
			String email =request.getParameter("email");
			String phone=request.getParameter("phone");
			User user =	new User(username,pwd,email,phone);

			if(userbiz.register(user)>0) {//登录成功
				response.sendRedirect(request.getContextPath()+"/admin.html");
			}else {//登录失败
				response.sendRedirect(request.getContextPath()+"/register.html");
			}
		}else if (method.equals("show")){
			User user=(User)session.getAttribute("user");
			String userJSON= JSON.toJSONStringWithDateFormat(user,"yyyy-MM-dd HH:mm:ss");
			out.print(userJSON);
		}else if (method.equals("loginOut")){
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/login.html");
		}else if (method.equals("userList")){
            List<User> userList=userbiz.getUserList();
            String userListJSON=JSON.toJSONStringWithDateFormat(userList,"yyyy-MM-dd HH:mm:ss");
            out.print(userListJSON);
        }else if (method.equals("userListPage")){
			int currentPage=request.getParameter("currentPage")==null?1:Integer.parseInt(request.getParameter("currentPage"));
			PageBean<User> page=new PageBean<>();
			page.setCurrentPage(currentPage);
			page.setTotalCount(userbiz.getUserCount());
			page.setPageData(userbiz.getUserListByPage(currentPage,page.getPageSize()));
			String userListPageJSON=JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd HH:mm:ss");
			out.print(userListPageJSON);
		}else if (method.equals("userListLayui")){
			//获得页面当前页码page,
			int page=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
			//获得页面页大小limit
			int limit=request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
			List<User> userList=userbiz.getUserListByPage(page,limit);
			StringBuilder sb = new StringBuilder("");
			sb.append("{" +
					"  \"code\": 0," +
					"  \"msg\": \"\"," +
					"  \"count\": "+userbiz.getUserCount()+"," +
					"  \"data\":");
			String userListJSON=JSON.toJSONStringWithDateFormat(userList,"yyyy-MM-dd HH:mm:ss");
			sb.append(userListJSON);//拼接对象数组
			sb.append("}");
			out.print(sb.toString());
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
