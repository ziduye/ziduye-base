/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ziduye.modules.sys.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ziduye.utils.base.Exceptions;
import com.ziduye.utils.base.StringUtils;
import com.ziduye.utils.resources.Global;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.method.HandlerMethod;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.ziduye.modules.base.service.SpringContextHolder;
import com.ziduye.modules.base.util.CacheUtils;
import com.ziduye.modules.sys.entity.Log;
import com.ziduye.modules.sys.entity.Menu;
import com.ziduye.modules.sys.entity.User;
import com.ziduye.modules.sys.service.LogService;
import com.ziduye.modules.sys.service.MenuService;

/**
 * 日志工具类
 * @author ThinkGem
 * @version 2014-11-7
 */
public class LogUtils {
	
	public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";

	private static LogService logService = SpringContextHolder.getBean(LogService.class);
	private static MenuService menuService = SpringContextHolder.getBean(MenuService.class);
	
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title){
		saveLog(request, null, null, title);
	}
	
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title){
		User user = UserUtils.getUser();
		if (user != null && user.getId() != null){
			Log log = new Log();
			log.setTitle(title);
			log.setType(ex == null ? Log.TYPE_ACCESS : Log.TYPE_EXCEPTION);
			log.setRemoteAddr(StringUtils.getRemoteAddr(request));
			log.setUserAgent(request.getHeader("user-agent"));
			log.setRequestUri(request.getRequestURI());
			log.setParams(request.getParameterMap());
			log.setMethod(request.getMethod());
			// 异步保存日志
			new SaveLogThread(log, handler, ex).start();
		}
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread{
		
		private Log log;
		private Object handler;
		private Exception ex;
		
		public SaveLogThread(Log log, Object handler, Exception ex){
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}
		
		@Override
		public void run() {
			// 获取日志标题
			if (StringUtils.isBlank(log.getTitle())){
				String permission = "";
				if (handler instanceof HandlerMethod){
					Method m = ((HandlerMethod)handler).getMethod();
					RequiresPermissions rp = m.getAnnotation(RequiresPermissions.class);
					permission = (rp != null ? StringUtils.join(rp.value(), ",") : "");
				}
				log.setTitle(getMenuNamePath(log.getRequestUri(), permission));
			}
			// 如果有异常，设置异常信息
			if(ex != null){
				log.setException(Exceptions.getStackTraceAsString(ex));
			}
			// 如果无标题并无异常日志，则不保存信息
			if (StringUtils.isBlank(log.getTitle()) && StringUtils.isBlank(log.getException())){
				return;
			}
			// 保存日志信息
			log.preInsert();
			logService.insert(log);
		}
	}

	/**
	 * 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
	 */
	public static String getMenuNamePath(String requestUri, String permission){
		String href = StringUtils.substringAfter(requestUri, Global.getAdminPath());
		@SuppressWarnings("unchecked")
		Map<String, String> menuMap = (Map<String, String>)CacheUtils.getSysCache(CACHE_MENU_NAME_PATH_MAP);
		if (menuMap == null){
			menuMap = Maps.newHashMap();
			List<Menu> menuList = menuService.listAll();
			for (Menu menu : menuList){
				// 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
				String namePath = "";
				if (menu.getPids() != null){
					List<String> namePathList = Lists.newArrayList();
					for (String id : StringUtils.split(menu.getPids(), ",")){
						for (Menu m : menuList){
							if (m.getId().equals(id)){
								namePathList.add(m.getText());
								break;
							}
						}
					}
					namePathList.add(menu.getText());
					namePath = StringUtils.join(namePathList, "-");
				}
				// 设置菜单名称路径
				if (StringUtils.isNotBlank(menu.getUrl())){
					menuMap.put(menu.getUrl(), namePath);
				}else if (StringUtils.isNotBlank(menu.getPermissions())){
					for (String p : StringUtils.split(menu.getPermissions())){
						menuMap.put(p, namePath);
					}
				}
				
			}
			CacheUtils.putSysCache(CACHE_MENU_NAME_PATH_MAP, menuMap);
		}
		String menuNamePath = menuMap.get(href);
		if (menuNamePath == null){
			for (String p : StringUtils.split(permission)){
				menuNamePath = menuMap.get(p);
				if (StringUtils.isNotBlank(menuNamePath)){
					break;
				}
			}
			if (menuNamePath == null){
				return "";
			}
		}
		return menuNamePath;
	}

	
}
