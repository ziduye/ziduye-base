package com.ziduye.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ziduye.utils.bean.MsgModel;
import com.ziduye.base.web.CrudContrller;
import com.ziduye.modules.sys.entity.User;
import com.ziduye.modules.sys.service.UserService;


@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class UserController extends CrudContrller<User> {

	@Autowired
	private UserService sysUserService;
	
	@RequestMapping(value = {"forward_user_list", ""})
	public String query(User usr,Model model) {
		return "sys/sys_user_list";
	}
	
	@Override
	public List<User> page(User user) {
		return sysUserService.list(user);
	}

	@Override
	public String display() {
		User obj=null;
		String id= parameter("id");
		if(id.equals(""))
		{
			obj = new User();
			request().setAttribute("behavior","insert");
		}
		else
		{
			obj=sysUserService.get(id);
			request().setAttribute("behavior","update");
		}
		request().setAttribute("viewObj",obj);
		return "sys/sys_user_edit";
	}

	@Override
	public MsgModel insert(User t) {
		int i = sysUserService.insert(t);
		if(i>0){
			return MsgModel.TrueBean("插入记录成功");
		}else{
			return MsgModel.FalseBean("插入记录失败!");
		}
	}

	@Override
	public MsgModel update(User t) {
		int i = sysUserService.update(t);
		if(i>0){
			return MsgModel.TrueBean("更新记录成功");
		}else{
			return MsgModel.FalseBean("更新记录失败!");
		}
	}

	@Override
	public MsgModel remove() {
		String id = parameter("id");
		int i = sysUserService.remove(id);
		if(i>0){
			return MsgModel.TrueBean("删除记录成功");
		}else{
			return MsgModel.FalseBean("删除记录失败!");
		}
	}
	/**
	 * 用户里面点击分配角色显示角色页面
	 * @return
	 */
	@RequestMapping(value = {"rolesOfUser", ""})
	public String rolesOfUser()
	{
		String userId = parameter("userId");
		request().setAttribute("userId", userId);
		return "sys/sysuser_roleSet";
	}
}
