package com.zwwSys.util;

/**
 * 前后端交互数据封装类
 * @author john
 * @since 2017.10.10
 */
public class AppResponseBody {

	 /**
     * 0: indicate success; 1: indicate fail
     */
    private int retnCode;
    
    /**
     * descripte the retnCode
     */
    private String retnDesc = "";
   
    /**
     * the data server returned
     */
    private Object data;
   
    public int getRetnCode() {
        return retnCode;
    }

    public void setRetnCode(int retnCode) {
        this.retnCode = retnCode;
    }

    public String getRetnDesc() {
        return retnDesc;
    }

    public void setRetnDesc(String retnDesc) {
        this.retnDesc = retnDesc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
	
}
