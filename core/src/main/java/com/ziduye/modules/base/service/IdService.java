package com.ziduye.modules.base.service;

import java.io.Serializable;

import com.ziduye.utils.base.Ids;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.stereotype.Service;

@Service
public class IdService implements SessionIdGenerator {

	@Override
	public Serializable generateId(Session session) {
		return Ids.uuid();
	}
}