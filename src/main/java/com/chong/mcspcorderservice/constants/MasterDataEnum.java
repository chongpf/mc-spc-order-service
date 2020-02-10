package com.chong.mcspcorderservice.constants;

public enum MasterDataEnum {
    // 支付状态
    PAYMENT_STATUS_WAITPAY("8","PAYMENT_STATUS","1","PAY_WAIT",""),
    PAYMENT_STATUS_SUCCESS("8","PAYMENT_STATUS","1","PAY_SUCCESS",""),
    PAYMENT_STATUS_FAILED("8","PAYMENT_STATUS","1","PAY_FAILED",""),
    // 退款状态
    REFOUND_STATUS_APPLAY("5","REFOUND_STATUS","1","REFOUND_WAIT",""),
    REFOUND_STATUS_ACCEPT("5","REFOUND_STATUS","2","REFOUND_ACCEPT",""),
    REFOUND_STATUS_SUCCESS("5","REFOUND_STATUS","3","REFOUND_SUCCESS",""),
    REFOUND_STATUS_FAILED("5","REFOUND_STATUS","4","REFOUND_FAILED",""),
    // 是否有可退款余额
    BALANCE_FOR_REFOUND_EXIST("4","BALANCE_FOR_REFOUND","1","BALANCE_EXIST",""),
    BALANCE_FOR_REFOUND_NOT_EXIST("4","BALANCE_FOR_REFOUND","0","BALANCE_NOT_EXIST",""),
    ;
    private String code;
    private String name;
    private String statusCode;
    private String statusName;
    private String notes;

    private MasterDataEnum(String code,String name,String statusCode,String statusName,String notes) {
        this.code = code;
        this.name = name;
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.notes = notes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
