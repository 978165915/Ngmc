package com.neu.demo01.entity;
/**
 * 用户实体类
 * @author Administrator
 *
 */
public class User {
	private int user_id;//用户id  D
	private String user_name;//用户名 D
	private String user_password;//密码 D
	private String email;//邮箱 D
	private String phone;//手机 D

	public User() {
	}

	public User(String user_name, String user_password, String email, String phone) {
		this.user_name = user_name;
		this.user_password = user_password;
		this.email = email;
		this.phone = phone;

	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
