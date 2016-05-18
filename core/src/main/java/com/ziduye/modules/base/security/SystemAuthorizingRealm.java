/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ziduye.modules.base.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.utils.Encodes;

import com.ziduye.base.Const;
import com.ziduye.base.util.Global;
import com.ziduye.base.web.Servlets;
import com.ziduye.modules.sys.entity.Menu;
import com.ziduye.modules.sys.service.SystemService;
import com.ziduye.modules.sys.util.LogUtils;
import com.ziduye.modules.sys.util.UserUtils;

/**
 * 系统安全认证实现类
 * @author ThinkGem
 * @version 2014-7-5
 */
public class SystemAuthorizingRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private SystemService systemService;

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	/**
	 * 认证回调函数, 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String loginName = token.getUsername();
		int activeSessionSize = systemService.getActiveSessions().size();
		if (logger.isDebugEnabled()){
			logger.debug("login submit, active session size: {}, username: {}", activeSessionSize,loginName);
		}
		
		// 校验登录验证码
//		if (LoginController.isValidateCodeLogin(token.getUsername(), false, false)){
//			Session session = SystemService.getSession();
//			String code = (String)session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
//			if (token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)){
//				throw new AuthenticationException("msg:验证码错误, 请重试.");
//			}
//		}
		
		// 校验用户名密码
		IUser user = systemService.getUserByLoginName(loginName);
		if (user != null) {
			if (Const.NO.equals(user.getLoginFlag())){
				throw new AuthenticationException("msg:该已帐号禁止登录.");
			}
			//TODO 根据不同的登录方式用不同的方法验证
			byte[] salt = Encodes.decodeHex(user.getPassword().substring(0,16));
			return new SimpleAuthenticationInfo(new Principal(user, token.isMobileLogin()), 
					user.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取当前已登录的用户
		Principal principal = (Principal) getAvailablePrincipal(principals);
		//是否允许一个帐号多次登录(配置文件)
		if (!Const.TRUE.equals(Global.getConfig("user.multiAccountLogin"))){
			Collection<Session> sessions = systemService.getSessionDao().getActiveSessions(true, principal, SystemService.getSession());
			if (sessions.size() > 0){
				// 如果是登录进来的，则踢出已在线用户
				if (SystemService.getSubject().isAuthenticated()){
					for (Session session : sessions){
						systemService.getSessionDao().delete(session);
					}
				}
				// 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
				else{
					SystemService.getSubject().logout();
					throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
				}
			}
		}
		IUser user = systemService.getUserByLoginName(principal.getLoginName());
		if (user != null) {
			// 添加用户权限
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<Menu> list = UserUtils.getUserMenuList();
			for (Menu menu : list){
				if (StringUtils.isNotBlank(menu.getPermissions())){
					// 添加基于Permission的权限信息
					for (String permission : StringUtils.split(menu.getPermissions(),",")){
						info.addStringPermission(permission);
					}
				}
			}
			// 添加用户角色信息
//			List<Role> roleList = UserUtils.getUserRoleList();
//			for (Role role : roleList){
//				info.addRole(role.getName());
//			}
			
			info.addStringPermission("user");
			// 更新登录IP和时间
			systemService.updateUserLoginInfo(user);
			// 记录登录日志
			LogUtils.saveLog(Servlets.request(), "系统登录");
			
			return info;
		} else {
			return null;
		}
	}
	
	@Override
	protected void checkPermission(Permission permission, AuthorizationInfo info) {
		authorizationValidate(permission);
		super.checkPermission(permission, info);
	}
	
	@Override
	protected boolean[] isPermitted(List<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
        		authorizationValidate(permission);
            }
        }
		return super.isPermitted(permissions, info);
	}
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, Permission permission) {
		authorizationValidate(permission);
		return super.isPermitted(principals, permission);
	}
	
	@Override
	protected boolean isPermittedAll(Collection<Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
            	authorizationValidate(permission);
            }
        }
		return super.isPermittedAll(permissions, info);
	}
	
	/**
	 * 授权验证方法
	 * @param permission
	 */
	private void authorizationValidate(Permission permission){
		// 模块授权预留接口
	}
	
	/**
	 * 设定密码校验的Hash算法与迭代次数
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(SystemService.HASH_ALGORITHM);
		matcher.setHashIterations(SystemService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}
	

	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String id; // 编号
		private String loginName; // 登录名
		private String name; // 姓名
		private boolean mobileLogin; // 是否手机登录
		
//		private Map<String, Object> cacheMap;

		public Principal(IUser user, boolean mobileLogin) {
			this.id = user.getUserId();
			this.loginName = user.getLoginName();
			this.name = user.getUserName();
			this.mobileLogin = mobileLogin;
		}

		public String getId() {
			return id;
		}

		public String getLoginName() {
			return loginName;
		}

		public String getName() {
			return name;
		}

		public boolean isMobileLogin() {
			return mobileLogin;
		}

		@Override
		public String toString() {
			return id;
		}

	}
}
