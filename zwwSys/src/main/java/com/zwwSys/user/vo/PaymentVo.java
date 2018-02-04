package com.zwwSys.user.vo;
/**
 * 充值
 * @author lc
 *
 */
public class PaymentVo {
	
	private String id;
	
	private String totals;
	
	private String amount;
	
	private String date;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTotals() {
		return totals;
	}

	public void setTotals(String totals) {
		this.totals = totals;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
