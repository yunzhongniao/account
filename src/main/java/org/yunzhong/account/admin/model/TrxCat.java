package org.yunzhong.account.admin.model;

public class TrxCat extends AcctBasicEntity {
    private String trxCode;
    private Integer trxCat;
    private String trxName;
    private String trxDir;

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public Integer getTrxCat() {
        return trxCat;
    }

    public void setTrxCat(Integer trxCat) {
        this.trxCat = trxCat;
    }

    public String getTrxName() {
        return trxName;
    }

    public void setTrxName(String trxName) {
        this.trxName = trxName;
    }

    public String getTrxDir() {
        return trxDir;
    }

    public void setTrxDir(String trxDir) {
        this.trxDir = trxDir;
    }

}
