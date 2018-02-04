package com.zwwSys.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwwSys.user.service.SupplyService;
import com.zwwSys.user.vo.PrizeVo;
import com.zwwSys.user.vo.UserAwardRecordsVo;
import com.zwwSys.user.vo.UserBaseVo;
import com.zwwSys.util.AppResponseBody;

@Controller
@RequestMapping("/supply")
public class SupplyController {
	
	@Autowired
	private SupplyService supplyService;

	
	/**
	 * 系统补发金币
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/gold/modify", method = RequestMethod.POST)
	public AppResponseBody supplyGoldModify(@RequestBody UserBaseVo vo){
		
		AppResponseBody app = new AppResponseBody();
		
		int num = supplyService.modifyUserGolds(vo);
		
		app.setData(num);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
	
	
	
	/**
	 * 系统补发娃娃
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/award/modify", method = RequestMethod.POST)
	public AppResponseBody supplyAwardModify(@RequestBody UserAwardRecordsVo vo){
		
		AppResponseBody app = new AppResponseBody();
		
		int num = supplyService.supplyAward(vo);
		
		app.setData(num);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
	
	/**
	 * 娃娃列表
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/prize/show", method = RequestMethod.POST)
	public AppResponseBody supplyPrizeShow(){
		
		AppResponseBody app = new AppResponseBody();
		
		List<PrizeVo>  vos = supplyService.showPrizes();
		
		app.setData(vos);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
}
