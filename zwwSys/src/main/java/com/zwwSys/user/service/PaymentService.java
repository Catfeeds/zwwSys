package com.zwwSys.user.service;

import java.util.List;

import com.zwwSys.user.vo.PaymentVo;
/**
 * 充值统计
 * @author lc
 *
 */
public interface PaymentService {
	/**
	 * 总计
	 * @return
	 */
	public PaymentVo showTotals();
	
	/**
	 * 每天
	 * @param date
	 * @return
	 */
	public List<PaymentVo> showTotalEveryday();
	
	/**
	 * 插入
	 */
	public void insert(String date, boolean batchFlg);
	
}
