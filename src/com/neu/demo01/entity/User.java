package com.neu.demo01.entity;
/**
 * 用户实体类
 * @author Administrator
 *
 */
public class User {
	private int user_id;//用户id
	private String user_name;//用户名
	private String user_password;//密码
	private String nick_name;//昵称
	private String rights;//权限
	private String role_id;//角色id
	private String last_login;//上次登录时间
	private String ip;//登录ip
	private String status;//状态
	private String skin;//皮肤样式
	private String email;//邮箱
	private String user_number;//固话
	private String phone;//手机
	private Integer man_buyer_id;//产商,借卖方ID

	public User() {
	}

	public User(String user_name, String user_password, String nick_name, String role_id, String skin, String email, String phone) {
		this.user_name = user_name;
		this.user_password = user_password;
		this.nick_name = nick_name;
		this.role_id = role_id;
		this.skin = skin;
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
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getMan_buyer_id() {
		return man_buyer_id;
	}
	public void setMan_buyer_id(Integer man_buyer_id) {
		this.man_buyer_id = man_buyer_id;
	}
	
	
	
	
}
