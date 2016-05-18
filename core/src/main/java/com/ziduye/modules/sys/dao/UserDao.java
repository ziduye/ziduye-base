package com.ziduye.modules.sys.dao;

import com.ziduye.base.dao.CrudDao;
import com.ziduye.base.repository.mybatis.MyBatisRepository;
import com.ziduye.modules.sys.entity.User;

@MyBatisRepository
public interface UserDao extends CrudDao<User> {
	/**
	 * 更新登录信息
	 * @param user
	 * @return
	 */
	
	/**
	 * 更新用户密码
	 * @param user
	 * @return
	 */
	public int updatePassword(User user);
	/**
	 * 根据登录名查找用户
	 * @param loginName
	 * @return
	 */
	public User getByLoginName(String loginName);
}
