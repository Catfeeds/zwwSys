package com.zwwSys.batch.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zwwSys.batch.repository.GrabDataMapper;
import com.zwwSys.batch.service.GrabDataService;
import com.zwwSys.constants.DbConstants;
@Service
public class GrabDataServiceImpl implements GrabDataService{
	
	@Resource
	private GrabDataMapper grabDataMapper;
	
	
	private String toatalSQL = "SELECT SUM(graberbNum) AS graberb_num, SUM(catchNumber) AS catch_number, ";
	
	private String TotalMidStr = " FROM(";
	
	private String toatalEndStr =  ") t ";
	
	private String querySQL = "SELECT COUNT(1) AS graberbNum, "
			+ "CASE WHEN SUM(final_result) IS NULL THEN 0 ELSE SUM(final_result) END AS catchNumber";
	private String tableName = " FROM  " + DbConstants.USER_GRAB_RECORDS;
	private String conditionSQL = " WHERE create_time LIKE ";
	
	
	@Override
	public int getGrabNumber(int n, String date) {
		
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
		
		int num = grabDataMapper.insertGrabRegister(sqlStr);
		return num;
	}
	
}
