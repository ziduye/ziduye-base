package com.ziduye.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ziduye.base.service.CrudService;
import com.ziduye.modules.sys.dao.MenuDao;
import com.ziduye.modules.sys.entity.Menu;
import com.ziduye.modules.sys.entity.Role;

@Service
@Transactional(readOnly = true)
public class MenuService extends CrudService<MenuDao, Menu>{
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * 根据用户id查询对应的菜单
	 * @param userId
	 * @return
	 */
	public List<Menu> listByUserId(String userId){
		List<Role> roles = roleService.listByUserId(userId);
		List<Menu> menus = Lists.newArrayList();
		for(Role role : roles){
			if(role != null && role.isNormail()){
				menus.addAll(dao.listByRoleId(role.getId()));
			}
		}
		return menus;
		
	}
	
	/**
	 * 根据角色id查询对应的菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> listByRoleId(String roleId){
		return dao.listByRoleId(roleId);
	}
}