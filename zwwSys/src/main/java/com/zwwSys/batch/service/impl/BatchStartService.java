package com.zwwSys.batch.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.zwwSys.batch.repository.BatchStartMapper;
import com.zwwSys.batch.service.GrabDataService;
import com.zwwSys.batch.service.RechargeDataService;
import com.zwwSys.batch.service.UserDataService;
import com.zwwSys.constants.DbConstants;

public class BatchStartService {

	private BatchStartMapper batchStartMapper;
	
	private UserDataService userDataService;
	
	private RechargeDataService rechargeDataService;
	
	private GrabDataService grabDataService;
	
	public void BatchStart() {
		
		// 获取user_id
		int maxUserId = batchStartMapper.queryUserLogin();
		
		// 获取前一日日期
		String date = LocalDate.now().minusDays(1).toString();
		
		try {
			userDataService.getUserRegister(date);
		}catch(Exception e) {
			
		}
		
		try {
			int n = getNumberByTable(maxUserId, DbConstants.USER_RECHARGE_RECORDS);
			rechargeDataService.getRechargeAmt(n, date);
		}catch(Exception e) {
			
		}
	
		try {
			int n = getNumberByTable(maxUserId, DbConstants.USER_GRAB_RECORDS);
			grabDataService.getGrabNumber(n, date);
		}catch(Exception e) {
			
		}
		
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
