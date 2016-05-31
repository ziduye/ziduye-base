package com.ziduye.modules.sys.entity;

import com.google.common.collect.Lists;
import com.ziduye.base.entity.DataEntity;

import java.util.List;

public class Role extends DataEntity<Role> {
	
	private String roleSN;
	private String roleName;
	private String roleType;
	
	private List<Menu> menuList = Lists.newArrayList();

    public String getRoleSN() {
        return roleSN;
    }

    public void setRoleSN(String roleSN) {
        this.roleSN = roleSN;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
}
