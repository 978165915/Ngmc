package com.neu.demo01.biz.impl;

import java.sql.SQLException;
import java.util.List;

import com.neu.demo01.biz.UserBiz;
import com.neu.demo01.dao.impl.UserDaoImpl;
import com.neu.demo01.entity.User;

public class UserBizImpl implements UserBiz {

	@Override
	public User login(String username, String pwd) {
		// TODO Auto-generated method stub
		try {
			return new UserDaoImpl().getUserByUsername(username, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int register(User user) {
		try {
			return new UserDaoImpl().save(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<User> getUserList() {
		try {
			return new UserDaoImpl().getUserList();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getUserListByPage(int currentPage, int pageSize) {
		try {
			return new UserDaoImpl().getUserListByPage(currentPage,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getUserCount() {
		try {
			return new UserDaoImpl().getUserCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean isExistUserName(String username) {
		try {
			return new UserDaoImpl().isExistUserName(username);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
