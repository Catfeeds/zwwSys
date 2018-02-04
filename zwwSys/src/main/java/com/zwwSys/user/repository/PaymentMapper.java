package com.zwwSys.user.repository;

import java.util.List;

import com.zwwSys.user.vo.PaymentVo;

public interface PaymentMapper {

	public PaymentVo countAllRecharge();
	
	public List<PaymentVo> everydayRecharge();
	
}
