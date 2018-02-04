package com.zwwSys.user.vo;
/**
 * 用户管理
 * @author lc
 *
 */
public class UserVo {
	private String id;
	
	private String number;
	
	private String date;

	private String totals;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
