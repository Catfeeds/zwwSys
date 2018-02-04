package com.zwwSys.user.service;

import com.zwwSys.user.vo.AdminVo;
/**
 * 管理员相关
 * @author lc
 *
 */
public interface AdminService {
	/**
	 * 登录
	 * @param vo
	 */
	public boolean login(AdminVo vo);
}
