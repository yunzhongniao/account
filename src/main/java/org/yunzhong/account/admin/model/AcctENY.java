package org.yunzhong.account.admin.model;

import java.util.Date;

public class AcctENY extends AcctBasicEntity {
    private String osbId;
    private String voucherType;
    private String voucherNo;
    private Integer isCusAcct;
    private String acctNo;
    private String currType;
    private Long entryNo;
    private Long entryPty;
    private String pid;
    private String trxCode;
    private String trxId;
    private String refVoucherNo;
    private String parentTrxId;
    private String childTrxId;
    private Date entryDate;
    private Integer crdr;
    private Double amount;

    public String getOsbId() {
        return osbId;
    }

    public void setOsbId(String osbId) {
        this.osbId = osbId;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getIsCusAcct() {
        return isCusAcct;
    }

    public void setIsCusAcct(Integer isCusAcct) {
        this.isCusAcct = isCusAcct;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getCurrType() {
        return currType;
    }

    public void setCurrType(String currType) {
        this.currType = currType;
    }

    public Long getEntryNo() {
        return entryNo;
    }

    public void setEntryNo(Long entryNo) {
        this.entryNo = entryNo;
    }

    public Long getEntryPty() {
        return entryPty;
    }

    public void setEntryPty(Long entryPty) {
        this.entryPty = entryPty;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public String getRefVoucherNo() {
        return refVoucherNo;
    }

    public void setRefVoucherNo(String refVoucherNo) {
        this.refVoucherNo = refVoucherNo;
    }

    public String getParentTrxId() {
        return parentTrxId;
    }

    public void setParentTrxId(String parentTrxId) {
        this.parentTrxId = parentTrxId;
    }

    public String getChildTrxId() {
        return childTrxId;
    }

    public void setChildTrxId(String childTrxId) {
        this.childTrxId = childTrxId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getCrdr() {
        return crdr;
    }

    public void setCrdr(Integer crdr) {
        this.crdr = crdr;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
