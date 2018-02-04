package com.zwwSys.user.vo;

/**
 * 
 * @author lc
 *
 */
public class UserRechargeRecordsVo {

	private String billId;

	private String billUserId;

	private String billTime;

	private String billAmt;

	private String billExplain;

	private String billKind;

	private String billStatus;

	private String billNumber;
	
	public String getBillUserId() {
		return billUserId;
	}

	public void setBillUserId(String billUserId) {
		this.billUserId = billUserId;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getBillTime() {
		return billTime;
	}

	public void setBillTime(String billTime) {
		this.billTime = billTime;
	}

	public String getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(String billAmt) {
		this.billAmt = billAmt;
	}

	public String getBillExplain() {
		return billExplain;
	}

	public void setBillExplain(String billExplain) {
		this.billExplain = billExplain;
	}

	public String getBillKind() {
		return billKind;
	}

	public void setBillKind(String billKind) {
		this.billKind = billKind;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

}
