/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ziduye.modules.base.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ziduye.base.entity.DataEntity;
import com.ziduye.utils.base.Reflections;
import com.ziduye.utils.base.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * 数据Entity类
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class TreeEntity<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;

	protected T parent;			// 父级
	protected List<T> childrens; //子级
	protected String parentIds; // 所有父级编号
	protected Integer sortNO;	// 排序编号
	
	public TreeEntity() {
		super();
		this.sortNO = 30;
	}
	
	public TreeEntity(String id) {
		super(id);
	}

	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	@JsonBackReference
	@NotNull
	public abstract T getParent();

	/**
	 * 父对象，只能通过子类实现，父类实现mybatis无法读取
	 * @return
	 */
	public abstract void setParent(T parent);

	@JsonBackReference
	@NotNull
	public abstract List<T> getChildrens();

	public abstract void setChildrens(List<T> childrens);

	@Length(min=1, max=2000)
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Integer getSortNO() {
		return sortNO;
	}

	public void setSortNO(Integer sortNO) {
		this.sortNO = sortNO;
	}
	
	public String getParentId() {
		String id = null;
		if (parent != null){
			id = (String) Reflections.getFieldValue(parent, "id");
		}
		return StringUtils.isNotBlank(id) ? id : "0";
	}
	
}
