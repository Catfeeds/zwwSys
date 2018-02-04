package com.zwwSys.user.service.impl;

import com.zwwSys.batch.repository.BatchStartMapper;
import com.zwwSys.batch.service.RechargeDataService;
import com.zwwSys.constants.DbConstants;
import com.zwwSys.constants.SignConstants;
import com.zwwSys.user.repository.PaymentMapper;
import com.zwwSys.user.service.PaymentService;
import com.zwwSys.user.vo.PaymentVo;
import com.zwwSys.util.TablesUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Resource
	private PaymentMapper paymentMapper;
	
	@Resource
	private RechargeDataService rechargeDataService;
	
	@Resource
	private BatchStartMapper batchStartMapper;

	@Override
	public PaymentVo showTotals() {
		
		PaymentVo vo = paymentMapper.countAllRecharge();
		return vo;
	}

	@Override
	public List<PaymentVo> showTotalEveryday() {
		
		List<PaymentVo> vos = paymentMapper.everydayRecharge();
		
		return vos;
	}

	/**
	 * 用户充值统计信息生成
	 * @param date
	 * @param batchFlg
	 */
	@Override
	public void insert(String date, boolean batchFlg) {
		// 获取最大user_id
		int maxUserId = batchStartMapper.queryUserLogin();
		int n = TablesUtils.getNumberByTable(maxUserId, DbConstants.USER_RECHARGE_RECORDS);

		if (!batchFlg) {
			// 不是定时任务的处理
			// 获取当前日期
			LocalDate crrDate = LocalDate.now();
			// 如果当前日期=结束日期，截止当前的统计信息全部更新
			if (SignConstants.TOTAL_END_DATE.equals(crrDate.toString())) {
				// 日期每日递减，如果该日期有数据就更新，否则就追加
				while (true) {
					updateUserRechargeStatisticsInfo(n, crrDate.toString());
					if (SignConstants.TOTAL_START_DATE.equals(crrDate.toString())) {
						break;
					} else {
						crrDate = crrDate.minusDays(1);
					}
				}
			} else {
				updateUserRechargeStatisticsInfo(n, crrDate.toString());
			}
		} else {
			// 定时任务的处理
			updateUserRechargeStatisticsInfo(n, date);
		}
	}

	/**
	 * 更新用户充值统计信息
	 * @param date
	 */
	private void updateUserRechargeStatisticsInfo(int n, String date) {
		// 获取该日期的统计数据
		int count = paymentMapper.queryUserRechargeStatisticsByDate(date);
		// 判断，为0就追加数据，为1就更新数据
		if (count == 0) {
			// 追加
			rechargeDataService.getRechargeAmt(n, date);
		} else {
			// 更新
			paymentMapper.updateUserRechargeStatisticsInfo(date);
			rechargeDataService.getRechargeAmt(n, date);
		}
	}

}
