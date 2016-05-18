package com.ziduye.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class BaseService {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
}
