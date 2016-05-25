package com.ziduye.modules.sys.dao;

import com.ziduye.base.dao.CrudDao;
import com.ziduye.base.repository.mybatis.MyBatisRepository;
import com.ziduye.modules.sys.entity.Log;

@MyBatisRepository
public interface LogDao extends CrudDao<Log> {
	
	
}
