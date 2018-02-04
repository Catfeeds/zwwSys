package com.zwwSys.user.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;

import com.zwwSys.constants.SignConstants;
import org.springframework.stereotype.Service;

import com.zwwSys.batch.service.UserDataService;
import com.zwwSys.user.repository.UserMapper;
import com.zwwSys.user.service.UserService;
import com.zwwSys.user.vo.UserVo;

/**
 * 注册用户统计Service实现类
 *
 * @author kuang
 * @since 2018.02.04
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserDataService userDataService;

	/**
	 * 获取注册用户总计值
	 * @return
	 */
	@Override
	public UserVo showTotals() {
		UserVo userVo = userMapper.countAllUsers();
		return userVo;
	}

	/**
	 * 获取每天的注册用户合计信息
	 * @return
	 */
	@Override
	public List<UserVo> showTotalEveryDy() {
		
		List<UserVo> userVos = userMapper.everydayUsers();
		return userVos;
	}

	/**
	 * 以日为单位，追加注册用户统计数据信息
	 * @param date
	 */
	@Override
	public void insert(String date, boolean batchFlg) {

		if (!batchFlg) {
			// 不是定时任务的处理
			// 获取当前日期
			LocalDate crrDate = LocalDate.now();
			// 如果当前日期=结束日期，截止当前的统计信息全部更新
			if (SignConstants.TOTAL_END_DATE.equals(crrDate.toString())) {
				// 日期每日递减，如果该日期有数据就更新，否则就追加
				while (true) {
					updateUserStatisticsInfo(crrDate.toString());
					if (SignConstants.TOTAL_START_DATE.equals(crrDate.toString())) {
						break;
					} else {
						crrDate = crrDate.minusDays(1);
					}
				}
			} else {
				updateUserStatisticsInfo(crrDate.toString());
			}
		} else {
			// 定时任务的处理
			updateUserStatisticsInfo(date);
		}
		
	}

	/**
	 * 更新注册用户统计信息
	 * @param date
	 */
	private void updateUserStatisticsInfo(String date) {
		// 获取该日期的统计数据
		int count = userMapper.queryUserStatisticsByDate(date);
		// 判断，为0就追加数据，为1就更新数据
		if (count == 0) {
			// 追加
			userDataService.getUserRegister(date);
		} else {
			// 更新
			userMapper.updateUserStatisticsInfo(date);
			userDataService.getUserRegister(date);
		}
	}
	
}
