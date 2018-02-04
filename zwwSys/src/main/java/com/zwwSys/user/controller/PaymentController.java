package com.zwwSys.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwwSys.user.service.PaymentService;
import com.zwwSys.user.vo.PaymentVo;
import com.zwwSys.util.AppResponseBody;

@Controller
@RequestMapping("/pay")
public class PaymentController {
	
	@Resource
	private PaymentService paymentService;
	
	
	/**
	 * 总计
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/now/totals", method = RequestMethod.POST)
	public AppResponseBody payNowTotals(){
		
		AppResponseBody app = new AppResponseBody();
		
		PaymentVo vo = paymentService.showTotals();
		
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
		
		List<PaymentVo> vo = paymentService.showTotalEveryday();
		
		app.setData(vo);
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}

	/**
	 * 插入数据到【运营充值统计表】
	 * @param vo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public AppResponseBody insertEveryday(@RequestBody PaymentVo vo){
		
		AppResponseBody app = new AppResponseBody();
		
		paymentService.insert(vo.getDate(), false);
		
		app.setRetnCode(200);
		app.setRetnDesc("");
		
		return app;
	}

}
