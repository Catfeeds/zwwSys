package com.zwwSys.user.pojo;

/**
 * 获奖记录pojo
 * 
 * @author john
 * @since 2017.11.7
 */
public class AwardRecordsPojo {

	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 机器id
	 */
	private String macId;

	/**
	 * 用户获奖记录表名
	 */
	private String userTableName;
	
	/**
	 * 机器获奖记录表名
	 */
	private String macTableName;
	
	/**
	 * 用户id
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户id
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 机器id
	 * @return
	 */
	public String getMacId() {
		return macId;
	}

	/**
	 * 机器id
	 * @param macId
	 */
	public void setMacId(String macId) {
		this.macId = macId;
	}

	/**
	 * 用户获奖记录表名
	 * @return
	 */
	public String getUserTableName() {
		return userTableName;
	}

	/**
	 * 用户获奖记录表名
	 * @param userTableName
	 */
	public void setUserTableName(String userTableName) {
		this.userTableName = userTableName;
	}

	/**
	 * 机器获奖记录表名
	 * @return
	 */
	public String getMacTableName() {
		return macTableName;
	}

	/**
	 * 机器获奖记录表名
	 * @param macTableName
	 */
	public void setMacTableName(String macTableName) {
		this.macTableName = macTableName;
	}
	
}
