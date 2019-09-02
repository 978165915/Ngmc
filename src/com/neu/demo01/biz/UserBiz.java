package com.neu.demo01.biz;

import com.neu.demo01.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserBiz {

	User login(String username, String pwd);
	int register(User user);
	List<User> getUserList();
	List<User>getUserListByPage(int currentPage,int pageSize);
	int getUserCount();
	//检测用户名是否存在
	public boolean isExistUserName(String username);
	public boolean isExistEmail(String email);
	public boolean isExistPhone(String phone);
}
