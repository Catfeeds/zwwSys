package com.zwwSys.user.repository;

import java.util.List;

import com.zwwSys.user.vo.PaymentVo;
import org.springframework.stereotype.Component;

@Component
public interface PaymentMapper {

	public PaymentVo countAllRecharge();
	
	public List<PaymentVo> everydayRecharge();

	/**
	 * 查询该日期的统计信息
	 * @param date
	 * @return
	 */
	int queryUserRechargeStatisticsByDate(String date);

	/**
	 * 更新该日期的统计信息
	 * @param date
	 * @return
	 */
	int updateUserRechargeStatisticsInfo(String date);
	
}
