package com.zwwSys.user.service;

import java.util.List;

import com.zwwSys.user.vo.UserVo;

/**
 * 注册用户统计Service类
 *
 * @author kuang
 * @since 2018.02.04
 * @version 1.0
 */
public interface UserService {
	/**
	 * 总计
	 * @return
	 */
	public UserVo showTotals();
	
	/**
	 * 每日
	 * @return
	 */
	public List<UserVo> showTotalEveryDy();
	
	/**
	 * 插入
	 */
	public void insert(String date, boolean batchFlg);
	
}
