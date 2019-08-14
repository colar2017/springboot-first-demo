package com.wyq.firstdemo.enums;

public enum ExcelTypeEnum {
    XLSX("xlsx"),
    XLS("xls");


    private final String value;

    ExcelTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
