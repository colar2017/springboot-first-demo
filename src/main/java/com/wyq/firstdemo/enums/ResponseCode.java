package com.wyq.firstdemo.enums;

/**
 * @ClassName ResponseCode
 * @Description 返回状态
 * @Author weiyanqiang
 * @Date 2019/6/26 11:24
 * @Version 1.0
 */
public enum ResponseCode {

    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    ILLEGAL_ARGUMENT(2, "ILLEGAL_ARGUMENT"),
    EXCEPTION(-1, "EXCEPTION");

    private final int code;

    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
