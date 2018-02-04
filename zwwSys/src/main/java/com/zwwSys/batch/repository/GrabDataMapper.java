package com.zwwSys.batch.repository;

import org.apache.ibatis.annotations.Param;

public interface GrabDataMapper {

	public int insertGrabRegister(@Param("sqlStr")String sqlStr);
}
