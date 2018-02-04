package com.zwwSys.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;
import com.zwwSys.batch.repository.BatchStartMapper;
import com.zwwSys.batch.service.GrabDataService;
import com.zwwSys.constants.DbConstants;
import com.zwwSys.user.repository.GrabMapper;
import com.zwwSys.user.service.GrabService;
import com.zwwSys.user.vo.GrabVo;
@Service
public class GrabServiceImpl implements GrabService{
	
	@Resource
	private GrabMapper grabMapper;
	
	@Resource
	private BatchStartMapper batchStartMapper;
	
	@Resource
	private GrabDataService grabDataService;

	@Override
	public GrabVo showTotals() {
		
		
		GrabVo vo = grabMapper.countAllGrabRecords();
		return vo;
	}

	@Override
	public List<GrabVo> showTotalEveryday() {
		
		List<GrabVo> vos = grabMapper.everydayGrabRecords();
		
		return vos;
	}

	@Override
	public int insert(String date) {
		// 获取user_id
		int maxUserId = batchStartMapper.queryUserLogin();
		int n = getNumberByTable(maxUserId, DbConstants.USER_GRAB_RECORDS);
		
		// 获取前一日日期
		//String date = LocalDate.now().minusDays(1).toString();
		int num = grabDataService.getGrabNumber(n, date);
		return num;
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
