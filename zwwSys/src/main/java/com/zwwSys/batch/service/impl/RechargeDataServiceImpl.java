package com.zwwSys.batch.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwwSys.batch.repository.PayDataMapper;
import com.zwwSys.batch.service.RechargeDataService;
import com.zwwSys.constants.DbConstants;
@Service
public class RechargeDataServiceImpl implements RechargeDataService{
	
	@Resource
	private PayDataMapper payDataMapper;
	
	private String toatalSQL = "select sum(amt) as amount, ";
	
	private String TotalMidStr = " FROM(";
	
	private String toatalEndStr =  ") t ";
	
	private String querySQL = "SELECT CASE WHEN SUM(amt) IS NULL THEN 0 ELSE SUM(amt) END AS amt";
	private String tableName = " FROM " + DbConstants.USER_RECHARGE_RECORDS;
	private String conditionSQL = " WHERE kind in ('0','1') AND status = '1' AND  create_time LIKE ";
	
	@Override
	public void getRechargeAmt(int n, String date) {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<n;i++) {
			
			sb.append(querySQL);
			sb.append(",");
			sb.append("'" + date + "'");
			sb.append(",");
			sb.append("'1'");
			sb.append(tableName + "_" + (i+1));
			sb.append(conditionSQL);
			sb.append("'" + date + "%'");
			
			if(i!=n-1) {
				sb.append(" UNION ALL ");
			}
		}
		
		String sqlStr = toatalSQL + "'" + date + "', " + "'1'" + TotalMidStr + sb.toString() + toatalEndStr;
		
		payDataMapper.insertPaymentRegister(sqlStr);
	}
}
