package com.com.entity.enums;

/**
 * @author 短途游
 */

public enum WebResponseEnum {
    SUCCESS("200", "success"),
    FAILURE("500", "unknown_error"),
    UNAUTHORIZED("401", "unauthorized");


    private String  code;
    private String desc;

    WebResponseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
