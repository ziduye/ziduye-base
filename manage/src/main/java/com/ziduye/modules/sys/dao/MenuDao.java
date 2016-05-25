package com.ziduye.modules.sys.dao;

import java.util.List;

import com.ziduye.base.dao.CrudDao;
import com.ziduye.base.repository.mybatis.MyBatisRepository;
import com.ziduye.modules.sys.entity.Menu;

@MyBatisRepository
public interface MenuDao extends CrudDao<Menu> {
	public List<Menu> listByRoleId(String roleId);
	
	public List<Menu> findByParentIdsLike(Menu menu);
	
}
