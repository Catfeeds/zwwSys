package com.zwwSys.user.pojo;

/**
 * 
 * @author lc
 *
 */
public class UserRechargeRecordsPojo  {
	
    private String userId;

    private Integer amt;  

    private String number;

    private int kind;

    private String outNumber;

    private int status;
    
    private String tableName;
    
    private String billExplain;
    

	public String getBillExplain() {
		return billExplain;
	}

	public void setBillExplain(String billExplain) {
		this.billExplain = billExplain;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

    public Integer getAmt() {
		return amt;
	}

	public void setAmt(Integer amt) {
		this.amt = amt;
	}

	public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }


    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(String outNumber) {
        this.outNumber = outNumber == null ? null : outNumber.trim();
    }

   
}