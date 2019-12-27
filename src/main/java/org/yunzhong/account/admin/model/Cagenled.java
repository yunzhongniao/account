package org.yunzhong.account.admin.model;

public class Cagenled extends AcctBasicEntity {
    private String osbID;
    private String itemCode;
    private Integer itemBalby;
    private Integer itemClass;
    private String currType;
    
    public String getOsbID() {
        return osbID;
    }
    public void setOsbID(String osbID) {
        this.osbID = osbID;
    }
    public String getItemCode() {
        return itemCode;
    }
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    public Integer getItemBalby() {
        return itemBalby;
    }
    public void setItemBalby(Integer itemBalby) {
        this.itemBalby = itemBalby;
    }
    public Integer getItemClass() {
        return itemClass;
    }
    public void setItemClass(Integer itemClass) {
        this.itemClass = itemClass;
    }
    public String getCurrType() {
        return currType;
    }
    public void setCurrType(String currType) {
        this.currType = currType;
    }
}
