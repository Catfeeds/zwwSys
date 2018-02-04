package com.zwwSys.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;
import com.zwwSys.batch.repository.BatchStartMapper;
import com.zwwSys.batch.repository.GoldStatisticsMapper;
import com.zwwSys.batch.service.GoldStatisticsService;
import com.zwwSys.constants.DbConstants;
import com.zwwSys.user.service.GoldService;
import com.zwwSys.user.vo.GoldStatisticsVo;
@Service
public class GoldServiceImpl implements GoldService{
	
	@Resource
	private GoldStatisticsService goldStatisticsService;
	
	@Resource
	private BatchStartMapper batchStartMapper;
	
	@Resource
	private GoldStatisticsMapper goldStatisticsMapper;
	
	/**
	 * 获取平台总金币
	 */
	@Override
	public List<GoldStatisticsVo> showPlatGolds() {
		
		int maxUserId = batchStartMapper.queryUserLogin();
		int n = getNumberByTable(maxUserId, DbConstants.USER_RECHARGE_RECORDS);
		
		String redPacketGolds = goldStatisticsService.getRedPacketGolds(n).getRedPacketGolds();
		
		String platformGolds = goldStatisticsMapper.queryGoldsByPlat().getPlatformGolds();
		
		GoldStatisticsVo vo1 = new GoldStatisticsVo();
		vo1.setName("红包");
		vo1.setValue(redPacketGolds);
		
		GoldStatisticsVo vo2 = new GoldStatisticsVo();
		vo2.setName("平台");
		vo2.setValue(platformGolds);
		
		List<GoldStatisticsVo> vos = new ArrayList<GoldStatisticsVo>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(vo1);
				add(vo2);
			}
		};
	
		return vos;
		
	}
	
	
	
	/**
	 * 水平切分大表
	 * 
	 * @param id 数据id
	 * @param tableName 库表名称 
	 * @return
	 */
	private static int getNumberByTable(int maxUserId, String tableName) {
		
		Integer num = instance().get(tableName);
		Integer order = maxUserId/num + 1;
		
		return order;
	}
	
	private static Map<String, Integer> instance() {
		Map<String, Integer> map = new HashMap<String, Integer>() {
			{
				put(DbConstants.USER_RECHARGE_RECORDS, 50000);
				put(DbConstants.USER_GRAB_RECORDS, 10000);
				put(DbConstants.USER_AWARD_RECORDS, 100000);
				put(DbConstants.MACHINE_AWARD_RECORDS, 500);
				put(DbConstants.RED_PACKET, 200000);
				put(DbConstants.RED_PACKET_DETAIL, 10000);
			}
		};
		final Map<String, Integer> MAP = ImmutableMap.copyOf(map);
		return MAP;
	
	}

	

}
