package com.zwwSys.user.service;

import java.util.List;

import com.zwwSys.user.vo.GrabVo;
/**
 * 抓取统计
 * @author lc
 *
 */
public interface GrabService {
	/**
	 * 总计
	 * @return
	 */
	public GrabVo showTotals();
	
	/**
	 * 每天
	 * @param date
	 * @return
	 */
	public List<GrabVo> showTotalEveryday();
	
	/**
	 * 插入
	 */
	public int insert(String date);
	
}
