package com.ziduye.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziduye.utils.bean.MsgModel;
import com.ziduye.base.web.CrudContrller;
import com.ziduye.modules.sys.entity.Menu;
import com.ziduye.modules.sys.service.MenuService;


@Controller
@RequestMapping(value = "${adminPath}/sys/menu")
public class MenuController extends CrudContrller<Menu> {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = {"forward_menu_list", ""})
	public String query(Menu usr,Model model) {
		return "modules/sys/menu_list";
	}
	
	@Override
	public List<Menu> page(Menu menu) {
		return menuService.list(menu);
	}

	@Override
	public String display() {
		Menu obj = null;
		String id= parameter("id");
		if(id.equals(""))
		{
			obj = new Menu();
			request().setAttribute("behavior","insert");
		}
		else
		{
			obj = menuService.get(id);
			request().setAttribute("behavior","update");
		}
		request().setAttribute("viewObj",obj);
		return "modules/sys/menu_edit";
	}

	@Override
	public MsgModel insert(Menu t) {
		int i = menuService.insert(t);
		if(i>0){
			return MsgModel.TrueBean("插入记录成功");
		}else{
			return MsgModel.FalseBean("插入记录失败!");
		}
	}

	@Override
	public MsgModel update(Menu t) {
		int i = menuService.update(t);
		if(i>0){
			return MsgModel.TrueBean("更新记录成功");
		}else{
			return MsgModel.FalseBean("更新记录失败!");
		}
	}

	@Override
	public MsgModel remove() {
		String id = parameter("id");
		int i = menuService.remove(id);
		if(i>0){
			return MsgModel.TrueBean("删除记录成功");
		}else{
			return MsgModel.FalseBean("删除记录失败!");
		}
	}
}
