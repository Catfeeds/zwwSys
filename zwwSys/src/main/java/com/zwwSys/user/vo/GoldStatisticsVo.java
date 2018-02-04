package com.zwwSys.user.vo;
/**
 * 金币统计Vo
 * @author lc
 *
 */
public class GoldStatisticsVo {
	
	private String redPacketGolds;
	
	private String platformGolds;
	
	private String value;
	
	private String name;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRedPacketGolds() {
		return redPacketGolds;
	}

	public void setRedPacketGolds(String redPacketGolds) {
		this.redPacketGolds = redPacketGolds;
	}

	public String getPlatformGolds() {
		return platformGolds;
	}

	public void setPlatformGolds(String platformGolds) {
		this.platformGolds = platformGolds;
	}
	
}
