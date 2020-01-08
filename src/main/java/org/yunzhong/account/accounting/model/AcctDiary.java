package org.yunzhong.account.accounting.model;

import java.math.BigDecimal;

public class AcctDiary {
    private String accountBookId;

    private String acctno;

    private String periodday;

    private String currtype;

    private BigDecimal openbal;

    private BigDecimal opendrbal;

    private BigDecimal closedramt;

    private BigDecimal closedrcnt;

    private BigDecimal closedrbal;

    private BigDecimal opencrbal;

    private BigDecimal closecramt;

    private BigDecimal closecrcnt;

    private BigDecimal closecrbal;

    private BigDecimal closebal;

    private Byte iscus;

    private String acctname;

    private String itemcode;

    private String id;

    public String getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(String accountBookId) {
        this.accountBookId = accountBookId;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getPeriodday() {
        return periodday;
    }

    public void setPeriodday(String periodday) {
        this.periodday = periodday;
    }

    public String getCurrtype() {
        return currtype;
    }

    public void setCurrtype(String currtype) {
        this.currtype = currtype;
    }

    public BigDecimal getOpenbal() {
        return openbal;
    }

    public void setOpenbal(BigDecimal openbal) {
        this.openbal = openbal;
    }

    public BigDecimal getOpendrbal() {
        return opendrbal;
    }

    public void setOpendrbal(BigDecimal opendrbal) {
        this.opendrbal = opendrbal;
    }

    public BigDecimal getClosedramt() {
        return closedramt;
    }

    public void setClosedramt(BigDecimal closedramt) {
        this.closedramt = closedramt;
    }

    public BigDecimal getClosedrcnt() {
        return closedrcnt;
    }

    public void setClosedrcnt(BigDecimal closedrcnt) {
        this.closedrcnt = closedrcnt;
    }

    public BigDecimal getClosedrbal() {
        return closedrbal;
    }

    public void setClosedrbal(BigDecimal closedrbal) {
        this.closedrbal = closedrbal;
    }

    public BigDecimal getOpencrbal() {
        return opencrbal;
    }

    public void setOpencrbal(BigDecimal opencrbal) {
        this.opencrbal = opencrbal;
    }

    public BigDecimal getClosecramt() {
        return closecramt;
    }

    public void setClosecramt(BigDecimal closecramt) {
        this.closecramt = closecramt;
    }

    public BigDecimal getClosecrcnt() {
        return closecrcnt;
    }

    public void setClosecrcnt(BigDecimal closecrcnt) {
        this.closecrcnt = closecrcnt;
    }

    public BigDecimal getClosecrbal() {
        return closecrbal;
    }

    public void setClosecrbal(BigDecimal closecrbal) {
        this.closecrbal = closecrbal;
    }

    public BigDecimal getClosebal() {
        return closebal;
    }

    public void setClosebal(BigDecimal closebal) {
        this.closebal = closebal;
    }

    public Byte getIscus() {
        return iscus;
    }

    public void setIscus(Byte iscus) {
        this.iscus = iscus;
    }

    public String getAcctname() {
        return acctname;
    }

    public void setAcctname(String acctname) {
        this.acctname = acctname;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}