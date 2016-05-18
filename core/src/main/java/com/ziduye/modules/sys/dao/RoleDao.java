package com.ziduye.modules.sys.dao;

import java.util.List;

import com.ziduye.base.dao.CrudDao;
import com.ziduye.base.repository.mybatis.MyBatisRepository;
import com.ziduye.modules.sys.entity.Role;

@MyBatisRepository
public interface RoleDao extends CrudDao<Role> {

	public List<Role> listByUserId(String userId);
	
}
