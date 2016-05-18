package com.ziduye.base.dao;

import java.util.List;

import com.ziduye.base.entity.BaseEntity;

public interface CrudDao<T extends BaseEntity<T>> extends BaseDao {
	/**
	 * 获取单条数据
	 */
	public T get(String id);
	
	/**
	 * 查询所有数据列表
	 */
	public List<T> listAll();
	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 */
	public List<T> list(T entity);
	
	/**
	 * 插入数据
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 */
	public int update(T entity);
	
	/**
	 * 删除数据 
	 */
	public int remove(String id);
}
