package com.zwwSys.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwwSys.constants.DbConstants;
import com.zwwSys.user.pojo.AwardRecordsPojo;
import com.zwwSys.user.pojo.UserBasePojo;
import com.zwwSys.user.pojo.UserRechargeRecordsPojo;
import com.zwwSys.user.repository.SupplyMapper;
import com.zwwSys.user.service.SupplyService;
import com.zwwSys.user.vo.PrizeVo;
import com.zwwSys.user.vo.UserAwardRecordsVo;
import com.zwwSys.user.vo.UserBaseVo;
import com.zwwSys.user.vo.UserRechargeRecordsVo;
import com.zwwSys.util.TablesUtils;
import com.zwwSys.util.UUIDUtil;
@Service
public class SupplyServiceImpl implements SupplyService{
	
	
	@Resource
	private SupplyMapper supplyMapper;
	

	/**
	 * 补发金币
	 */
	@Override
	public int modifyUserGolds(UserBaseVo vo) {
		
		UserBasePojo pojo = new UserBasePojo();
		
		String userId = vo.getUserId();
		int golds = vo.getGold();
		
		pojo.setUserId(userId);
		pojo.setGold(golds);
		int num = supplyMapper.updateGoldsByUserId(pojo);
		
		UserRechargeRecordsPojo rechargePojo = new UserRechargeRecordsPojo();
		rechargePojo.setTableName(TablesUtils.segmentation(userId, 
				DbConstants.USER_RECHARGE_RECORDS));
		rechargePojo.setUserId(userId);
		rechargePojo.setAmt(golds);
		rechargePojo.setNumber(UUIDUtil.getUUID());
		rechargePojo.setOutNumber(UUIDUtil.getUUID());
		rechargePojo.setBillExplain(String.valueOf(golds));
		supplyMapper.insertRecharge(rechargePojo);
		
		return num;
	}


	/**
	 * 补发金币列表
	 */
	@Override
	public List<UserRechargeRecordsVo> supplyGoldList() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * 补发娃娃
	 */
	@Override
	public int supplyAward(UserAwardRecordsVo vo) {
		
		AwardRecordsPojo awardRecordsPojo = new AwardRecordsPojo();
		awardRecordsPojo.setMacId(vo.getMachineId());
		awardRecordsPojo.setUserId(vo.getUserId());
		awardRecordsPojo.setUserTableName(TablesUtils.segmentation(
				vo.getUserId(), DbConstants.USER_AWARD_RECORDS));
		
		int num = supplyMapper.insertUserAwardRecords(awardRecordsPojo);
		return num;
	}


	/**
	 * 娃娃信息
	 */
	@Override
	public List<PrizeVo> showPrizes() {
		List<PrizeVo>  vos = supplyMapper.queryPrizes();
		return vos;
	}

	

}
