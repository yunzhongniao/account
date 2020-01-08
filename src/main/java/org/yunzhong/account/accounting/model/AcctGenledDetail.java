package org.yunzhong.account.accounting.model;

import java.math.BigDecimal;

public class AcctGenledDetail {
    private String accountBookId;

    private String itemcode;

    private String periodday;

    private Byte itembalby;

    private Byte itemclass;

    private String currtype;

    private BigDecimal lddrbal;

    private BigDecimal ldcrbal;

    private BigDecimal tddramt;

    private BigDecimal tdcramt;

    private BigDecimal tddrcnt;

    private BigDecimal tdcrcnt;

    private BigDecimal tddrbal;

    private BigDecimal tdcrbal;

    public String getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(String accountBookId) {
        this.accountBookId = accountBookId;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getPeriodday() {
        return periodday;
    }

    public void setPeriodday(String periodday) {
        this.periodday = periodday;
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

    public String getCurrtype() {
        return currtype;
    }

    public void setCurrtype(String currtype) {
        this.currtype = currtype;
    }

    public BigDecimal getLddrbal() {
        return lddrbal;
    }

    public void setLddrbal(BigDecimal lddrbal) {
        this.lddrbal = lddrbal;
    }

    public BigDecimal getLdcrbal() {
        return ldcrbal;
    }

    public void setLdcrbal(BigDecimal ldcrbal) {
        this.ldcrbal = ldcrbal;
    }

    public BigDecimal getTddramt() {
        return tddramt;
    }

    public void setTddramt(BigDecimal tddramt) {
        this.tddramt = tddramt;
    }

    public BigDecimal getTdcramt() {
        return tdcramt;
    }

    public void setTdcramt(BigDecimal tdcramt) {
        this.tdcramt = tdcramt;
    }

    public BigDecimal getTddrcnt() {
        return tddrcnt;
    }

    public void setTddrcnt(BigDecimal tddrcnt) {
        this.tddrcnt = tddrcnt;
    }

    public BigDecimal getTdcrcnt() {
        return tdcrcnt;
    }

    public void setTdcrcnt(BigDecimal tdcrcnt) {
        this.tdcrcnt = tdcrcnt;
    }

    public BigDecimal getTddrbal() {
        return tddrbal;
    }

    public void setTddrbal(BigDecimal tddrbal) {
        this.tddrbal = tddrbal;
    }

    public BigDecimal getTdcrbal() {
        return tdcrbal;
    }

    public void setTdcrbal(BigDecimal tdcrbal) {
        this.tdcrbal = tdcrbal;
    }
}