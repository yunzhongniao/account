package org.yunzhong.account.admin.model;

public class AcctTemplate extends AcctBasicEntity {

    private Long tplId;
    private String tplName;
    private String osbType;
    private String acctType;
    private String acctNamePfx;
    private String acctNameAfx;
    private Integer forceFx;
    private String acctStatus;
    private String itemCode;
    private String itemName;
    private String ocType;
    private int allowPay;
    private int allowRecharge;
    private int allowDeposit;
    private int allowTfIn;
    private int allowTfOut;
    private int allowIn;
    private int allowOut;

    public String getTplName() {
        return tplName;
    }

    public void setTplName(String tplName) {
        this.tplName = tplName;
    }

    public String getOsbType() {
        return osbType;
    }

    public void setOsbType(String osbType) {
        this.osbType = osbType;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctNamePfx() {
        return acctNamePfx;
    }

    public void setAcctNamePfx(String acctNamePfx) {
        this.acctNamePfx = acctNamePfx;
    }

    public String getAcctNameAfx() {
        return acctNameAfx;
    }

    public void setAcctNameAfx(String acctNameAfx) {
        this.acctNameAfx = acctNameAfx;
    }

    public Integer getForceFx() {
        return forceFx;
    }

    public void setForceFx(Integer forceFx) {
        this.forceFx = forceFx;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getTplId() {
        return tplId;
    }

    public void setTplId(Long tplId) {
        this.tplId = tplId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOcType() {
        return ocType;
    }

    public void setOcType(String ocType) {
        this.ocType = ocType;
    }

    public int getAllowPay() {
        return allowPay;
    }

    public void setAllowPay(int allowPay) {
        this.allowPay = allowPay;
    }

    public int getAllowRecharge() {
        return allowRecharge;
    }

    public void setAllowRecharge(int allowRecharge) {
        this.allowRecharge = allowRecharge;
    }

    public int getAllowDeposit() {
        return allowDeposit;
    }

    public void setAllowDeposit(int allowDeposit) {
        this.allowDeposit = allowDeposit;
    }

    public int getAllowTfIn() {
        return allowTfIn;
    }

    public void setAllowTfIn(int allowTfIn) {
        this.allowTfIn = allowTfIn;
    }

    public int getAllowTfOut() {
        return allowTfOut;
    }

    public void setAllowTfOut(int allowTfOut) {
        this.allowTfOut = allowTfOut;
    }

    public int getAllowIn() {
        return allowIn;
    }

    public void setAllowIn(int allowIn) {
        this.allowIn = allowIn;
    }

    public int getAllowOut() {
        return allowOut;
    }

    public void setAllowOut(int allowOut) {
        this.allowOut = allowOut;
    }
}
