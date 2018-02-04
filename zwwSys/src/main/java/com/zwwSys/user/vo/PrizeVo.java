package com.zwwSys.user.vo;
/**
 * 
 * @author lc
 *
 */

public class PrizeVo {
	
	private String machineId; 
	
	private String prizeName;
	 
	private int exchange;
	
	private int consume;
	
	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public int getConsume() {
		return consume;
	}

	public void setConsume(int consume) {
		this.consume = consume;
	}

	public int getExchange() {
		return exchange;
	}

	public void setExchange(int exchange) {
		this.exchange = exchange;
	}


	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	
}
