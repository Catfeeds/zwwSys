package com.zwwSys.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwwSys.user.service.GoldService;
import com.zwwSys.user.vo.GoldStatisticsVo;
import com.zwwSys.util.AppResponseBody;

@Controller
@RequestMapping("/plat")
public class GoldController {
	
	@Resource
	private GoldService goldService;
	
	/**
	 * 平台总金币
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/gold/totals", method = RequestMethod.POST)
	public AppResponseBody goldPlatTotals(){
		
		AppResponseBody app = new AppResponseBody();
		
		List<GoldStatisticsVo> vos = goldService.showPlatGolds();
		
		app.setData(vos);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}
	
}
