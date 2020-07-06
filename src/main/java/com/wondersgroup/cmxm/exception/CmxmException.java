package com.wondersgroup.cmxm.exception;

import com.wondersgroup.cmxm.enums.ResultEnum;

public class CmxmException extends RuntimeException{

    private  Integer code;

    public CmxmException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
    public CmxmException(Integer code, String message){
        super(message);
        this.code=code;
    }
}
