package com.zwwSys.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwwSys.user.service.GrabService;
import com.zwwSys.user.vo.GrabVo;
import com.zwwSys.util.AppResponseBody;

@Controller
@RequestMapping("/grab")
public class GrabController {
	
	@Resource
	private GrabService grabService;
	
	
	/**
	 * 总计
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/now/totals", method = RequestMethod.POST)
	public AppResponseBody payNowTotals(){
		
		AppResponseBody app = new AppResponseBody();
		
		GrabVo vo = grabService.showTotals();
		
		app.setData(vo);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
	
	/**
	 * 每日充值  
	 * @param pvo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/everyday/totals", method = RequestMethod.POST)
	public AppResponseBody payEveryDayTotals(){
		
		AppResponseBody app = new AppResponseBody();
		
		List<GrabVo> vos = grabService.showTotalEveryday();
		
		app.setData(vos);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
	
	
	/**
	 * 插入
	 * @param pvo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public AppResponseBody insertEveryday(@RequestBody GrabVo vo){
		
		AppResponseBody app = new AppResponseBody();
		
		int num = grabService.insert(vo.getDate());
		
		app.setData(num);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}

}
