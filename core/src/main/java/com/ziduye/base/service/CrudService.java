/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ziduye.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ziduye.base.dao.CrudDao;
import com.ziduye.base.entity.DataEntity;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public List<T> list(T entity) {
		return dao.list(entity);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		if (entity.getIsNewRecord()){
			entity.preInsert();
			dao.insert(entity);
		}else{
			entity.preUpdate();
			dao.update(entity);
		}
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public int remove(String pk) {
		return dao.remove(pk);
	}
	
	/**
	 * 插入一条数据
	 * @param t
	 * @return
	 */
	@Transactional(readOnly = false)
	public int insert(T t) {
		return dao.insert(t);
	}
	
	/**
	 * 更新一条数据
	 * @param t
	 * @return
	 */
	@Transactional(readOnly = false)
	public int update(T t) {
		return dao.update(t);
	}

	@Transactional(readOnly = false)
	public List<T> all() {
		return dao.all();
	}

	
}
