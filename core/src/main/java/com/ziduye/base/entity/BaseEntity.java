package com.ziduye.base.entity;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ziduye.base.util.Global;

public abstract class BaseEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 默认主键（唯一标识）
	 */
	protected String id;

	/**
	 * 当前实体分页对象
	 */
	protected PageBean<T> page;

	/**
	 * 当前用户
	 * 
	 * protected User currentUser;
	 */

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	protected boolean isNewRecord = false;

	public BaseEntity() {

	}

	public BaseEntity(String id) {
		this();
		this.id = id;
	}

	/**
	 * 插入之前执行方法，子类实现
	 */
	public abstract void preInsert();

	/**
	 * 更新之前执行方法，子类实现
	 */
	public abstract void preUpdate();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public PageBean<T> getPage() {
		return page;
	}

	public void setPage(PageBean<T> page) {
		this.page = page;
	}

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 * 
	 * @return
	 */
	@JsonIgnore
	public boolean getIsNewRecord() {
		return isNewRecord || StringUtils.isBlank(getId());
	}

	/**
	 * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
	 * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
	 */
	public void setIsNewRecord(boolean isNewRecord) {
		this.isNewRecord = isNewRecord;
	}

	/**
	 * 全局变量对象
	 */
	@JsonIgnore
	public Global getGlobal() {
		return Global.getInstance();
	}

	/**
	 * 获取数据库名称
	 */
	@JsonIgnore
	public String getDbName() {
		return Global.getConfig("jdbc.type");
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		BaseEntity<?> that = (BaseEntity<?>) obj;
		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
