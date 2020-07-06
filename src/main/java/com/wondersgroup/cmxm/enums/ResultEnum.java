package com.wondersgroup.cmxm.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    MD5_ERROR(1,"MD5转换失败"),
    REGIST_ERROR(2,"注册失败"),
    QUESTION_IS_NULL(3,"没有问题记录"),
    SESSION_TIMEOUT(4,"session超时"),
    ENTRY_ERROR(5,"入参错误"),
    ;
    private Integer code;
    private String message;


    ResultEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }
}
