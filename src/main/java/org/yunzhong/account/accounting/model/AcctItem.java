package org.yunzhong.account.accounting.model;

public class AcctItem {
    private String accountBookType;

    private String itemcode;

    private String itemname;

    private Byte itembalby;

    private Byte itemclass;

    private String itemnotes;

    private Byte itemlevel;

    private String itemfather;

    private String currtype;

    private Byte mainacct;

    private Byte cqacct;

    public String getAccountBookType() {
        return accountBookType;
    }

    public void setAccountBookType(String accountBookType) {
        this.accountBookType = accountBookType;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Byte getItembalby() {
        return itembalby;
    }

    public void setItembalby(Byte itembalby) {
        this.itembalby = itembalby;
    }

    public Byte getItemclass() {
        return itemclass;
    }

    public void setItemclass(Byte itemclass) {
        this.itemclass = itemclass;
    }

    public String getItemnotes() {
        return itemnotes;
    }

    public void setItemnotes(String itemnotes) {
        this.itemnotes = itemnotes;
    }

    public Byte getItemlevel() {
        return itemlevel;
    }

    public void setItemlevel(Byte itemlevel) {
        this.itemlevel = itemlevel;
    }

    public String getItemfather() {
        return itemfather;
    }

    public void setItemfather(String itemfather) {
        this.itemfather = itemfather;
    }

    public String getCurrtype() {
        return currtype;
    }

    public void setCurrtype(String currtype) {
        this.currtype = currtype;
    }

    public Byte getMainacct() {
        return mainacct;
    }

    public void setMainacct(Byte mainacct) {
        this.mainacct = mainacct;
    }

    public Byte getCqacct() {
        return cqacct;
    }

    public void setCqacct(Byte cqacct) {
        this.cqacct = cqacct;
    }
}