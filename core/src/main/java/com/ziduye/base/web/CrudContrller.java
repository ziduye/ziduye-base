package com.ziduye.base.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ziduye.base.entity.BaseEntity;
import com.ziduye.base.entity.PageBean;
import com.ziduye.utils.bean.MsgModel;

public abstract class CrudContrller<T extends BaseEntity<T>> extends BaseController {

	public abstract List<T> page(T t );
	public abstract String display();
	public abstract MsgModel insert(T t );
	public abstract MsgModel update(T t);
	public abstract MsgModel remove();
	
	@ResponseBody
	@RequestMapping(value = {"list"})
	public PageBean<T> _page(T t ) {
		PageBean<T> page = new PageBean<T>(request(),response());
		t.setPage(page);
		List<T> query = page(t);
		page.setList(query);
		return page;
	}
	@RequestMapping(value = {"get"})
	public String _display() {
		return display();
	}
	
	@ResponseBody
	@RequestMapping(value = {"add"})
	public MsgModel _insert(T t) {
		return insert(t);
	}
	@ResponseBody
	@RequestMapping(value = {"update"})
	public MsgModel _update(T t) {
		return update(t);
	}
	@ResponseBody
	@RequestMapping(value = {"del"})
	public MsgModel _remove() {
		return remove();
	}
	

}
