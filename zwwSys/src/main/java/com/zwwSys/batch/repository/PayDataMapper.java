package com.zwwSys.batch.repository;

import org.apache.ibatis.annotations.Param;

public interface PayDataMapper {

	public int insertPaymentRegister(@Param("sqlStr")String sqlStr);
}
