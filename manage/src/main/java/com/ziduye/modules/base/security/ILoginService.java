package com.ziduye.modules.base.security;

public interface ILoginService {
	public IUser getUserByLoginName(String loginName);

    public IUser getUserByEmail(String email);

    public IUser getUserByMobilPhone(String mobilPhone);
}
