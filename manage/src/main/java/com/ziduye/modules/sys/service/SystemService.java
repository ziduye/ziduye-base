package com.ziduye.modules.sys.service;

import com.ziduye.base.security.shiro.session.SessionDAO;
import com.ziduye.modules.base.security.ILoginService;
import com.ziduye.modules.base.security.IUser;
import com.ziduye.utils.resources.Global;
import com.ziduye.utils.security.Digests;
import com.ziduye.utils.security.Encodes;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SystemService implements ILoginService{
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionDAO sessionDao;
	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
	public static void main(String[] args) {
		System.out.println(entryptPassword("admin"));
		System.out.println(validatePassword("admin", "bf2ab61d4f42fe1d57326f28542bf5fb7d6817028d6086512e0861d2"));
	}
	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		byte[] salt = Encodes.decodeHex(password.substring(0,16));
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
	}
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
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
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	
	/**
	 * 获得活动会话
	 * @return
	 */
	public Collection<Session> getActiveSessions(){
		return sessionDao.getActiveSessions(false);
	}
	/**
	 * 获取Key加载信息
	 */
	public static boolean printKeyLoadMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用 "+ Global.getConfig("productName")+" \r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
		return true;
	}
	
	@Override
	public IUser getUserByLoginName(String loginName) {
		return userService.getByLoginName(loginName);
	}

    @Override
    public IUser getUserByEmail(String email) {
        return null;
    }

    @Override
    public IUser getUserByMobilPhone(String mobilPhone) {
        return null;
    }

    public SessionDAO getSessionDao() {
		return sessionDao;
	}
	public void setSessionDao(SessionDAO sessionDao) {
		this.sessionDao = sessionDao;
	}
	/**
	 * 更新用户的登录信息
	 * @param user
	 */
	public void updateUserLoginInfo(IUser user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
