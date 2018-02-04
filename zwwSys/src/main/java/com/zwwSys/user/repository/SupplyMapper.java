package com.zwwSys.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zwwSys.user.pojo.AwardRecordsPojo;
import com.zwwSys.user.pojo.UserBasePojo;
import com.zwwSys.user.pojo.UserRechargeRecordsPojo;
import com.zwwSys.user.vo.PrizeVo;
import com.zwwSys.user.vo.UserRechargeRecordsVo;

public interface SupplyMapper {
	
	/**
	 * 更新用户金币
	 * @param gold
	 * @param userId
	 * @return
	 */
	public int updateGoldsByUserId(UserBasePojo pojo);
	
	/**
	 * 补发金币
	 * @param pojo
	 * @return
	 */
	public int insertRecharge(UserRechargeRecordsPojo pojo);
	
	/**
	 * 补发金币列表
	 * @return
	 */
	public List<UserRechargeRecordsVo> queryRecharges(@Param("tableName")String tableName);
	
	
	/**
	 * 系统补发娃娃
	 * @param pojo
	 * @return
	 */
	public int insertUserAwardRecords(AwardRecordsPojo pojo);
	
	/**
	 * 娃娃列表
	 * @return
	 */
	public List<PrizeVo> queryPrizes();
	
}
