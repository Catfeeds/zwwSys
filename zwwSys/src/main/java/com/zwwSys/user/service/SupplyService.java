package com.zwwSys.user.service;

import java.util.List;

import com.zwwSys.user.vo.PrizeVo;
import com.zwwSys.user.vo.UserAwardRecordsVo;
import com.zwwSys.user.vo.UserBaseVo;
/**
 * 用户统计
 * @author lc
 *
 */
import com.zwwSys.user.vo.UserRechargeRecordsVo;
public interface SupplyService {
	
	/**
	 * 系统补发金币
	 * @param vo
	 * @return
	 */
	public int modifyUserGolds(UserBaseVo vo);
	
	/**
	 * 补发金币历史
	 * @return
	 */
	public List<UserRechargeRecordsVo> supplyGoldList();
	
	/**
	 * 系统补发娃娃
	 * @param vo
	 * @return
	 */
	public int supplyAward(UserAwardRecordsVo vo);
	
	
	/**
	 * 娃娃信息
	 * @return
	 */
	public List<PrizeVo> showPrizes();
	
}
