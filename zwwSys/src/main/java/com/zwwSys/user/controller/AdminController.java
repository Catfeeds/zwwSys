package com.zwwSys.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwwSys.user.service.AdminService;
import com.zwwSys.user.vo.AdminVo;
import com.zwwSys.util.AppResponseBody;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private AdminService adminService;
	
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AppResponseBody versionNumber(@RequestBody AdminVo vo){
		
		AppResponseBody app = new AppResponseBody();
		
		Boolean flag = adminService.login(vo);
		
		app.setData(flag);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
			
	}
}
