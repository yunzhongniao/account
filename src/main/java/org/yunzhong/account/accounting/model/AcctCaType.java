package org.yunzhong.account.accounting.model;

public class AcctCaType {
    private String catypeid;

    private String accountBookType;

    private String catypename;

    private Byte iscus;

    public String getCatypeid() {
        return catypeid;
    }

    public void setCatypeid(String catypeid) {
        this.catypeid = catypeid;
    }

    public String getAccountBookType() {
        return accountBookType;
    }

    public void setAccountBookType(String accountBookType) {
        this.accountBookType = accountBookType;
    }

    public String getCatypename() {
        return catypename;
    }

    public void setCatypename(String catypename) {
        this.catypename = catypename;
    }

    public Byte getIscus() {
        return iscus;
    }

    public void setIscus(Byte iscus) {
        this.iscus = iscus;
    }
}