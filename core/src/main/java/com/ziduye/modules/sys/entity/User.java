package com.ziduye.modules.sys.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.ziduye.modules.base.entity.DataEntity;
import com.ziduye.modules.base.security.IUser;

public class User extends DataEntity<User> implements IUser{
	
	private static final long serialVersionUID = -6362467444987293320L;
	
	private String loginName;//登陆名
	private String password;//密码

	private String userName;//用户名
	private String email;//电子邮箱
	private String status;//账号状态-->0:未激活(未审核),1:正常,2:账号被锁定,9:账号已注销
	private Date regDate;//注册时间
	private Date lastLoginDate;//最后一次登陆时间
	
	/**
	 * 菜单列表
	 */
	private List<Menu> menus = Lists.newArrayList();
	/**
	 * 角色列表
	 */
	private List<Role> roles = Lists.newArrayList();
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public String getUserId() {
		return id;
	}
	@Override
	public String getLoginFlag() {
		return status;
	}
	public boolean isAdmin() {
		if("ziduye".equals(getUserName())){
			return true;
		}else{
			return false;			
		}
	}
}
