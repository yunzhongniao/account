package org.yunzhong.account.admin.model;

public class AcctCaType extends AcctBasicEntity {
    private String osbType;
    private String caTypeId;
    private String caTypeName;
    private Integer isCus;

    public String getOsbType() {
        return osbType;
    }

    public void setOsbType(String osbType) {
        this.osbType = osbType;
    }

    public String getCaTypeId() {
        return caTypeId;
    }

    public void setCaTypeId(String caTypeId) {
        this.caTypeId = caTypeId;
    }

    public String getCaTypeName() {
        return caTypeName;
    }

    public void setCaTypeName(String caTypeName) {
        this.caTypeName = caTypeName;
    }

    public Integer getIsCus() {
        return isCus;
    }

    public void setIsCus(Integer isCus) {
        this.isCus = isCus;
    }

}
