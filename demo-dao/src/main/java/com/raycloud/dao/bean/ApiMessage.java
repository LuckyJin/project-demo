package com.cn.dao.bean;

import java.util.*;

/**
 * Created by baomingfeng at 2017-12-14 03:41:53
 */
public class ApiMessage  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/*api_name*/
    private String apiName;

	/*sub_code*/
    private String subCode;

	/*message*/
    private String message;



    public String getApiName() {
       return apiName;
    }

    public void setApiName(String apiName) {
       this.apiName = apiName;
    }

    public String getSubCode() {
       return subCode;
    }

    public void setSubCode(String subCode) {
       this.subCode = subCode;
    }

    public String getMessage() {
       return message;
    }

    public void setMessage(String message) {
       this.message = message;
    }

}