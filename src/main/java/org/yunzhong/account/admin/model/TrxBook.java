package org.yunzhong.account.admin.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 流水账表
 */
public class TrxBook extends AcctBasicEntity{
    private String trxId;
    private BigDecimal paymentAmount;
    private String cusNum;
    private String cusName;
    private String otherNum;
    private String otherName;
    private String trxDir;
    private BigDecimal amount;
    private String osbId;
    private String trxCode;
    private int payChannelId;
    private String bankCode;
    private Date transDate;
    private Date accountDate;
    private String currency;
    private String summary;
    private String remarks;

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCusNum() {
        return cusNum;
    }

    public void setCusNum(String cusNum) {
        this.cusNum = cusNum;
    }

    public String getCusName() {
        return cusName;
    }

    public String getOsbId() {
        return osbId;
    }

    public void setOsbId(String osbId) {
        this.osbId = osbId;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getOtherNum() {
        return otherNum;
    }

    public void setOtherNum(String otherNum) {
        this.otherNum = otherNum;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getTrxDir() {
        return trxDir;
    }

    public void setTrxDir(String trxDir) {
        this.trxDir = trxDir;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public int getPayChannelId() {
        return payChannelId;
    }

    public void setPayChannelId(int payChannelId) {
        this.payChannelId = payChannelId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
