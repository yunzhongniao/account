package org.yunzhong.account.accounting.model;

public class AcctCurrencyType {
    private String currtype;

    private String currname;

    private Byte currlocal;

    public String getCurrtype() {
        return currtype;
    }

    public void setCurrtype(String currtype) {
        this.currtype = currtype;
    }

    public String getCurrname() {
        return currname;
    }

    public void setCurrname(String currname) {
        this.currname = currname;
    }

    public Byte getCurrlocal() {
        return currlocal;
    }

    public void setCurrlocal(Byte currlocal) {
        this.currlocal = currlocal;
    }
}