package com.ziduye.modules.sys.entity;

import com.ziduye.modules.base.entity.TreeEntity;

import java.util.List;

/**
 * 菜单
 * 
 * @author  ziduye(a)gmail.com
 * @since   2016年2月23日
 * @version 0.0.1
 */
public class Menu extends TreeEntity<Menu>  {
	
	private String text;//菜单名称
	private String url; //访问路径
	private String faicon;//显示图表
	private String pid;		//父级id
	private String pids;	//上级id
	private String type;	//菜单类型	: 1 : 模块,2: 菜单组 ,3:菜单项,4:菜单权限项,
	private String hide;	//非管理菜单是否显示
	private String permissions;//权限标识符
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFaicon() {
		return faicon;
	}
	public void setFaicon(String faicon) {
		this.faicon = faicon;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	@Override
	public Menu getParent() {
		return parent;
	}
	@Override
	public void setParent(Menu parent) {
		this.parent = parent;
	}

	@Override
	public List<Menu> getChildrens() {
		return childrens;
	}

	@Override
	public void setChildrens(List<Menu> childrens) {
		this.childrens = childrens;
	}
}
