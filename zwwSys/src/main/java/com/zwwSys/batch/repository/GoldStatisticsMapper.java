package com.zwwSys.batch.repository;
/**
 * 金币统计
 * @author lc
 *
 */

import org.apache.ibatis.annotations.Param;

import com.zwwSys.user.vo.GoldStatisticsVo;

public interface GoldStatisticsMapper {
	/**
	 * 查询平台总金币
	 * @return
	 */
	public  GoldStatisticsVo queryGoldsByPlat();
	
	
	/**
	 * 查询红包总金币
	 * @return
	 */
	public  GoldStatisticsVo queryGoldsByRedPacket(@Param("sqlStr")String sqlStr);

}
