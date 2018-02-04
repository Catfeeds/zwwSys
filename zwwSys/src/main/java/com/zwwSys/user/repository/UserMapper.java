package com.zwwSys.user.repository;

import com.zwwSys.user.vo.UserVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 注册用户统计查询Mapper类
 *
 * @author kuang
 * @since 2018.02.04
 * @version 1.0
 */
@Component
public interface UserMapper {
	/**
	 * 总用户
	 * @return
	 */
	public UserVo countAllUsers();
	
	/**
	 * 每天的用户列表
	 * @return
	 */
	public List<UserVo> everydayUsers();

	/**
	 * 查询该日期的统计信息
	 * @param date
	 * @return
	 */
	int queryUserStatisticsByDate(String date);

	/**
	 * 更新该日期的统计信息
	 * @param date
	 * @return
	 */
	int updateUserStatisticsInfo(String date);
	
}
