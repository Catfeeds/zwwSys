package com.zwwSys.batch.repository;

import org.springframework.stereotype.Component;

@Component
public interface BatchStartMapper {

	/**
	 * 查询用户最大id
	 */
	public int queryUserLogin();
}
