package com.zwwSys.user.pojo;
/**
 * 
 * @author lc
 *
 */ 
public class UserBasePojo {
	
    private String userId;

    private String userName;

    private int portraitNum;

    private int experience;

    private int gold;

    private int redPacketValue;

    private String inviteCode;

    private String exchangeCode;

    private int effective;
    
    private String tableName;
    
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPortraitNum(int portraitNum) {
		this.portraitNum = portraitNum;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getPortraitNum() {
        return portraitNum;
    }

    public void setPortraitNum(Integer portraitNum) {
        this.portraitNum = portraitNum;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getRedPacketValue() {
        return redPacketValue;
    }

    public void setRedPacketValue(Integer redPacketValue) {
        this.redPacketValue = redPacketValue;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode == null ? null : exchangeCode.trim();
    }

    

    public int getEffective() {
		return effective;
	}

	public void setEffective(int effective) {
		this.effective = effective;
	}

}