package com.zwwSys.batch.service;

import com.zwwSys.user.vo.GoldStatisticsVo;

public interface GoldStatisticsService {

	/**
	 * 红包总金币
	 * @param n
	 * @param date
	 */
	public GoldStatisticsVo getRedPacketGolds(int n);
	
}
