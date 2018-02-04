package com.zwwSys.user.service;

import java.util.List;

import com.zwwSys.user.vo.GoldStatisticsVo;

public interface GoldService {
	
	/**
	 * 平台总金币
	 * @param n
	 * @param date
	 */
	public List<GoldStatisticsVo> showPlatGolds();
	
}
