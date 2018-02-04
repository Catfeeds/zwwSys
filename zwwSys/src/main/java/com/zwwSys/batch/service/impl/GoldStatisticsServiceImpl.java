package com.zwwSys.batch.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwwSys.batch.repository.GoldStatisticsMapper;
import com.zwwSys.batch.service.GoldStatisticsService;
import com.zwwSys.constants.DbConstants;
import com.zwwSys.user.vo.GoldStatisticsVo;
@Service
public class GoldStatisticsServiceImpl implements GoldStatisticsService{
	
	
	@Resource
	private GoldStatisticsMapper goldStatisticsMapper;
	
	
	private String querySQL = "SELECT CASE WHEN SUM(exchange_amount) IS NULL THEN 0 ELSE SUM(exchange_amount) END  AS totals";
	private String tableName = " FROM " + DbConstants.RED_PACKET;
	private String conditionSQL = " WHERE effective = '1' ";
	
	/**
	 * 获取红包总金币
	 */
	@Override
	public GoldStatisticsVo getRedPacketGolds(int n) {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<n;i++) {
			
			sb.append(querySQL);
			sb.append(tableName + "_" + (i+1));
			sb.append(conditionSQL);
			
			if(i!=n-1) {
				sb.append(" UNION ALL ");
			}
		}
		
		GoldStatisticsVo vo = goldStatisticsMapper.queryGoldsByRedPacket(sb.toString());
		
		return vo;
	}

}
