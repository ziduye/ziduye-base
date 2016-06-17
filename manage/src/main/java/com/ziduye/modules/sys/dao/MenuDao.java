package com.ziduye.modules.sys.dao;

import java.util.List;

import com.ziduye.base.dao.CrudDao;
import com.ziduye.base.repository.mybatis.MyBatisRepository;
import com.ziduye.modules.sys.entity.Menu;

@MyBatisRepository
public interface MenuDao extends CrudDao<Menu> {

	/**
	 * 根据上级id查找所有的子菜单
	 * @param parentId 上级id
	 * @return
	 */
	List<Menu> listByParentId(String parentId);

	List<Menu> listByRoleId(String roleId);

	List<Menu> findByParentIdsLike(Menu menu);

}
