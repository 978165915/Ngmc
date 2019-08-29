package com.neu.demo01.dao;

import java.sql.SQLException;
import java.util.List;

import com.neu.demo01.entity.User;

/**
 * 用户接口
 * @author Administrator
 *
 */
public interface UserDao {
	//新增
	int save(User user) throws SQLException;
	//根据用户名获得用户
	User getUserByUsername(String username,String pwd) throws SQLException;
	List<User>getUserList() throws SQLException;
	List<User>getUserListByPage(int currentPage,int pageSize) throws SQLException;
	int getUserCount() throws SQLException;
}
