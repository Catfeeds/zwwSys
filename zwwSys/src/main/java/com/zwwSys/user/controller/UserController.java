package com.zwwSys.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwwSys.user.service.UserService;
import com.zwwSys.user.vo.PaymentVo;
import com.zwwSys.user.vo.UserVo;
import com.zwwSys.util.AppResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@ResponseBody
	@RequestMapping(value = "/now/totals", method = RequestMethod.POST)
	public AppResponseBody userNowTotals(){
		
		AppResponseBody app = new AppResponseBody();
		
		UserVo userVo = userService.showTotals();
		
		app.setData(userVo);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
	
	@ResponseBody
	@RequestMapping(value = "/everyday/totals", method = RequestMethod.POST)
	public AppResponseBody userEverydayTotals(){
		
		AppResponseBody app = new AppResponseBody();
		
		List<UserVo> userVos = userService.showTotalEveryDy();
		
		app.setData(userVos);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
	
	
	/**
	 * 插入数据到【运营用户统计表】
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public AppResponseBody insertEveryday(@RequestBody PaymentVo vo){
		
		AppResponseBody app = new AppResponseBody();
		
		userService.insert(vo.getDate(), false);
		
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}

}
