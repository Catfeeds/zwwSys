package com.zwwSys.batch.service;

public interface UserDataService {

	/**
	 * 每日批量获取用户注册数
	 * @param n
	 * @param date
	 */
	public int getUserRegister(String date);
	
}
