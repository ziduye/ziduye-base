package com.ziduye.modules.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ziduye.base.service.CrudService;
import com.ziduye.modules.sys.dao.UserDao;
import com.ziduye.modules.sys.entity.User;

@Service
@Transactional(readOnly = true)
public class UserService extends CrudService<UserDao, User>{

	/**
	 * 根据登录名查找用户
	 * @param loginName
	 * @return
	 */
	public User getByLoginName(String loginName){
		return dao.getByLoginName(loginName);
	}
	/**
	 * 更新登录信息
	 * @param user
	 * @return
	 */
	@Transactional(readOnly = false)
	public int updateLoginInfo(User user){
		return 0;
	}
	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	public int updatePassword(User user){
		return dao.updatePassword(user);
	}
	

}