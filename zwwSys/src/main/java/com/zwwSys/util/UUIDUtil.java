package com.zwwSys.util;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


public class UUIDUtil {

	 public UUIDUtil() { 
	    } 
	 
    /** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    }


    /**
     * 生成一个uuid
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    /**
     * 标志 + 用户表 xx + 分隔符 + 对应表id + 随机数
     */
    public static String makeTradeNo(int tableId, String id){
	    	Random rd = new Random();
	    	
	    	String s = "pay" + tableId + "zww" + id;
	    	String sb = s.length() + s + rd.nextInt(9999)+
	    			LocalTime.now().withNano(0).toString().replaceAll(":", ""); 
	    	return sb;
    }
    
    /**
     * 标志 + 用户表 xx + 分隔符 + 对应表id + 随机数
     */
    public static Map<String, String> getInfoFromTradeNo(String outTradeNo){
    	
	    	String[] s = outTradeNo.split("pay");
	    	String[] st = s[1].split("zww");
	    	int len = Integer.valueOf(s[0]) - 6 - st[0].length()  ;
	    	
	    	Map<String, String> param = new HashMap<>();
	    	param.put("id", st[1].substring(0, len));
	    	param.put("table", st[0]);
	    	
	    	return param;
    }
    
}
