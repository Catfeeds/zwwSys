package com.zwwSys.user.repository;

import java.util.List;

import com.zwwSys.user.vo.GrabVo;
/**
 * 抓取记录
 * @author lc
 *
 */
public interface GrabMapper {

	/**
	 * 总计
	 * @return
	 */
	public GrabVo countAllGrabRecords();
	
	/**
	 * 每天
	 * @return
	 */
	public List<GrabVo> everydayGrabRecords();
	
}
