package com.zwwSys.batch.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwwSys.batch.repository.UserDataMapper;
import com.zwwSys.batch.service.UserDataService;
@Service
public class UserDataServiceImpl implements UserDataService{
	@Resource
	private UserDataMapper UserDataMapper;
	
	@Override
	public int getUserRegister(String date) {
		int num = 0;
		try {
			num = UserDataMapper.insertUserRegister(date);
		}catch (Exception e){
			
		}
		return num;	
	}

}
