/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ziduye.modules.sys.util;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.ziduye.base.service.BaseService;
import com.ziduye.modules.base.security.SystemAuthorizingRealm.Principal;
import com.ziduye.modules.base.service.SpringContextHolder;
import com.ziduye.modules.base.util.CacheUtils;
import com.ziduye.modules.sys.entity.Menu;
import com.ziduye.modules.sys.entity.Role;
import com.ziduye.modules.sys.entity.User;
import com.ziduye.modules.sys.service.MenuService;
import com.ziduye.modules.sys.service.RoleService;
import com.ziduye.modules.sys.service.UserService;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-12-05
 */
public class UserUtils {

	private static UserService userService = SpringContextHolder.getBean(UserService.class);
	private static MenuService menuService = SpringContextHolder.getBean(MenuService.class);
	private static RoleService roleService = SpringContextHolder.getBean(RoleService.class);

	public static final String USER_CACHE_ID_ = "id_";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 null
	 */
	public static User getUser(){
		Principal principal = getPrincipal();
		if (principal != null){
			User user = getUser(principal.getId());
			if (user != null){
				return user;
			}
			return null;
		}
		return null;
	}
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回  null
	 */
	public static User getUser(String id){
		User user = (User)CacheUtils.getUserCache(USER_CACHE_ID_ + id);
		if (user ==  null){
			user = userService.get(id);
			if (user == null){
				return null;
			}
			CacheUtils.putUserCache(USER_CACHE_ID_ + user.getId(), user);
		}
		return user;
	}
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static User getByLoginName(String loginName){
		User user = userService.getByLoginName(loginName);
		if (user == null){
			return null;
		}
		return user;
	}
	
	/**
	 * 获取当前用户角色列表
	 * @return
	 */
	public static List<Role> getUserRoleList(){
		@SuppressWarnings("unchecked")
		List<Role> roleList = (List<Role>)getSessionCache(CACHE_ROLE_LIST);
		if (roleList == null){
			User user = getUser();
			if (user.isAdmin()){
				roleList = roleService.listAll();
			}else{
				roleList = roleService.listByUserId(user.getId());
			}
			putSessionCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}
	
	/**
	 * 获取当前用户授权菜单
	 * @return
	 */
	public static List<Menu> getUserMenuList(){
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>)getSessionCache(CACHE_MENU_LIST);
		if (menuList == null){
			User user = getUser();
			if (user.isAdmin()){
				menuList = menuService.listAll();
			}else{
				menuList = menuService.listByUserId(user.getId());
			}
			putSessionCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	
	// ============== User Cache ==============
	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(){
		removeSessionCache(CACHE_ROLE_LIST);
		removeSessionCache(CACHE_MENU_LIST);
		UserUtils.clearCache(getUser());
	}
	
	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(User user){
		CacheUtils.removeUserCache(USER_CACHE_ID_ + user.getId());
	}
	
	public static Object getSessionCache(String key) {
		return getSessionCache(key, null);
	}
	
	public static Object getSessionCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putSessionCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeSessionCache(String key) {
		getSession().removeAttribute(key);
	}
	
	
}
