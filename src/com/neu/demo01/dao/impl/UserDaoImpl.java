package com.neu.demo01.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neu.demo01.dao.UserDao;
import com.neu.demo01.entity.User;
import com.neu.demo01.util.DBUtil;
import com.neu.demo01.util.MD5;


public class  UserDaoImpl extends DBUtil implements UserDao {
	
	
	@Override
	public int save(User user) throws SQLException {
		String sql="insert into userinfo(username, password, email, phone) " +
				"values ( ?, ?, ?, ?)";
		return executeUpdate(sql,user.getUser_name(),MD5.MD5Encode(user.getUser_password()),
						user.getEmail(),user.getPhone());
	}

	@Override
	public User getUserByUsername(String username,String pwd) throws SQLException {
		String sql="select id, username, password,email, phone"
				+ " from userinfo where username=? and password=?";
		User user;
		try {
			rs = executeQuery(sql, username,MD5.MD5Encode(pwd));
			user = null;
			if (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("id"));
				user.setUser_name(rs.getString("username"));
				user.setEmail(rs.getString("email"));;
				user.setPhone(rs.getString("phone"));
			} 
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public List<User> getUserList() throws SQLException {
		List<User>userList=new ArrayList<>();
		String sql="select id, username, password, email, phone"
				+ " from userinfo";
		User user;
		try {
			rs = executeQuery(sql);
			user = null;
			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("id"));
				user.setUser_name(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				userList.add(user);
			}
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return userList;
	}

    @Override
    public List<User> getUserListByPage(int currentPage, int pageSize) throws SQLException {
        List<User>userList=new ArrayList<>();
        String sql="select id, username, password, email, phone"
                + " from userinfo limit ?,?";
        User user;
        try {
            rs = executeQuery(sql,(currentPage-1)*pageSize,pageSize);
            user = null;
            while (rs.next()) {
                user = new User();
                user.setUser_id(rs.getInt("id"));
                user.setUser_name(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                userList.add(user);
            }
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return userList;
    }

    @Override
    public int getUserCount() throws SQLException {
	    int count=0;
	    String sql="SELECT COUNT(id) FROM userinfo";
	    try{
            rs=executeQuery(sql,null);
            if(rs.next()){
                count=rs.getInt(1);
            }
        }finally {
	        closeAll(conn,pstmt,rs);
        }
        return count;
    }

    @Override
    public boolean isExistUserName(String username) throws SQLException {
        String sql="select id, username, password,email, phone"
                + " from userinfo where username=?";
        User user;
        try {
            rs = executeQuery(sql, username);
            if (rs.next()) {
                return true;
            }
        } finally {
            closeAll(conn, pstmt, rs);
        }
        return false;
    }

}
