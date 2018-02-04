package com.zwwSys.util;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.zwwSys.constants.DbConstants;

/**
 * 库表工具类
 * 
 * @author john
 * @since 2017.10.12
 */
public class TablesUtils {

	/**
	 * 水平切分大表
	 * 
	 * @param id 数据id
	 * @param tableName 库表名称 
	 * @return
	 */
	public static String segmentation(String id, String tableName) {
		
		Integer num = instance().get(tableName);
		Integer order = Integer.valueOf(id)/num + 1;
		
		return tableName + "_" + order;
	}

	/**
	 * 获取需要查询的表个数
	 *
	 * @param maxUserId 最大用户ID
	 * @param tableName 库表名称
	 * @return
	 */
	public static int getNumberByTable(int maxUserId, String tableName) {

		Integer num = instance().get(tableName);
		Integer order = maxUserId/num + 1;

		return order;
	}
	
	@SuppressWarnings("serial")
	public static Map<String, Integer> instance() {
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
