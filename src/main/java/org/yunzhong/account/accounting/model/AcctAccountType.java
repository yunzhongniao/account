package org.yunzhong.account.accounting.model;

public class AcctAccountType {
    private String accountBookType;

    private String accttype;

    private String typename;

    private Boolean cusentry;

    private Boolean caentry;

    public String getAccountBookType() {
        return accountBookType;
    }

    public void setAccountBookType(String accountBookType) {
        this.accountBookType = accountBookType;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Boolean getCusentry() {
        return cusentry;
    }

    public void setCusentry(Boolean cusentry) {
        this.cusentry = cusentry;
    }

    public Boolean getCaentry() {
        return caentry;
    }

    public void setCaentry(Boolean caentry) {
        this.caentry = caentry;
    }
}