package com.zwwSys.user.service.impl;

import org.springframework.stereotype.Service;

import com.zwwSys.user.service.AdminService;
import com.zwwSys.user.vo.AdminVo;

@Service
public class AdminServiceImpl implements AdminService{

	@Override
	public boolean login(AdminVo vo) {
		
		String account = "15202217034";
		String password = "123456";
		
		if (account.equals(vo.getAccount()) && password.equals(vo.getPassword())) {

			return true;
		}
		return false;
		
	}

}
