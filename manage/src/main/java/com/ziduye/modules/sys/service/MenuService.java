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
	 * 返回树结构的全部菜单
	 * @return
     */
	public List<Menu> listTree(){
		List<Menu> result = listByParentId("0");
		for (Menu m : result) {

		}

	}

	/**
	 * 根据上级id查找所有的子菜单
	 * @param parentId 上级id
	 * @return
	 */
	public List<Menu> listByParentId(String parentId){
		List<Menu> result = dao.listByParentId(parentId);
		if (result == null) {
			result = Lists.newArrayList();
		}
		return result;
	}

	/**
	 * 根据角色id查询对应的菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> listByRoleId(String roleId){
		List<Menu> result = dao.listByRoleId(roleId);
		if (result == null) {
			result = Lists.newArrayList();
		}
		return result;
	}



}