package com.ziduye.modules.sys.entity;

import java.util.List;

import com.google.common.collect.Lists;
import com.ziduye.base.entity.DataEntity;

public class Role extends DataEntity<Role> {
	
	private String name;
	private String pid;
	private String pids;
	
	private List<Menu> menuList = Lists.newArrayList();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPids() {
		return pids;
	}
	public void setPids(String pids) {
		this.pids = pids;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
}
