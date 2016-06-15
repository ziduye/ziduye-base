package com.ziduye.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ziduye.base.service.CrudService;
import com.ziduye.modules.sys.dao.RoleDao;
import com.ziduye.modules.sys.entity.Role;

@Service
@Transactional(readOnly = true)
public class RoleService extends CrudService<RoleDao, Role>{
	/**
	 * 根据用户id查询角色列表
	 * @param userId
	 * @return
	 */
	public List<Role> listByUserId(String userId){
		return null;//dao.listByUserId(userId);
	}
}