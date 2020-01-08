package org.yunzhong.account.accounting.model;

import java.math.BigDecimal;

public class AcctTemplate {
    private Long tplid;

    private String tplname;

    private String accountBookType;

    private String accttype;

    private String acctnamepfx;

    private String acctnameafx;

    private String acctnameformula;

    private Byte forcefx;

    private String acctstatus;

    private String itemcode;

    private Byte allowpay;

    private Byte allowrecharge;

    private Byte allowdeposit;

    private Byte allowtfin;

    private Byte allowtfout;

    private Byte allowin;

    private Byte allowout;

    private BigDecimal overdramamt;

    private BigDecimal drmaxamt;

    private BigDecimal crmaxamt;

    private BigDecimal drdtmaxamt;

    private BigDecimal drdtmaxcnt;

    private BigDecimal drmtmaxamt;

    private BigDecimal drmtmaxcnt;

    private BigDecimal crdtmaxamt;

    private BigDecimal crdtmaxcnt;

    private BigDecimal crmtmaxamt;

    private BigDecimal crmtmaxcnt;

    private Boolean reglimitcusswitch;

    private Boolean reglimitcaswitch;

    private String octype;

    public Long getTplid() {
        return tplid;
    }

    public void setTplid(Long tplid) {
        this.tplid = tplid;
    }

    public String getTplname() {
        return tplname;
    }

    public void setTplname(String tplname) {
        this.tplname = tplname;
    }

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

    public String getAcctnamepfx() {
        return acctnamepfx;
    }

    public void setAcctnamepfx(String acctnamepfx) {
        this.acctnamepfx = acctnamepfx;
    }

    public String getAcctnameafx() {
        return acctnameafx;
    }

    public void setAcctnameafx(String acctnameafx) {
        this.acctnameafx = acctnameafx;
    }

    public String getAcctnameformula() {
        return acctnameformula;
    }

    public void setAcctnameformula(String acctnameformula) {
        this.acctnameformula = acctnameformula;
    }

    public Byte getForcefx() {
        return forcefx;
    }

    public void setForcefx(Byte forcefx) {
        this.forcefx = forcefx;
    }

    public String getAcctstatus() {
        return acctstatus;
    }

    public void setAcctstatus(String acctstatus) {
        this.acctstatus = acctstatus;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public Byte getAllowpay() {
        return allowpay;
    }

    public void setAllowpay(Byte allowpay) {
        this.allowpay = allowpay;
    }

    public Byte getAllowrecharge() {
        return allowrecharge;
    }

    public void setAllowrecharge(Byte allowrecharge) {
        this.allowrecharge = allowrecharge;
    }

    public Byte getAllowdeposit() {
        return allowdeposit;
    }

    public void setAllowdeposit(Byte allowdeposit) {
        this.allowdeposit = allowdeposit;
    }

    public Byte getAllowtfin() {
        return allowtfin;
    }

    public void setAllowtfin(Byte allowtfin) {
        this.allowtfin = allowtfin;
    }

    public Byte getAllowtfout() {
        return allowtfout;
    }

    public void setAllowtfout(Byte allowtfout) {
        this.allowtfout = allowtfout;
    }

    public Byte getAllowin() {
        return allowin;
    }

    public void setAllowin(Byte allowin) {
        this.allowin = allowin;
    }

    public Byte getAllowout() {
        return allowout;
    }

    public void setAllowout(Byte allowout) {
        this.allowout = allowout;
    }

    public BigDecimal getOverdramamt() {
        return overdramamt;
    }

    public void setOverdramamt(BigDecimal overdramamt) {
        this.overdramamt = overdramamt;
    }

    public BigDecimal getDrmaxamt() {
        return drmaxamt;
    }

    public void setDrmaxamt(BigDecimal drmaxamt) {
        this.drmaxamt = drmaxamt;
    }

    public BigDecimal getCrmaxamt() {
        return crmaxamt;
    }

    public void setCrmaxamt(BigDecimal crmaxamt) {
        this.crmaxamt = crmaxamt;
    }

    public BigDecimal getDrdtmaxamt() {
        return drdtmaxamt;
    }

    public void setDrdtmaxamt(BigDecimal drdtmaxamt) {
        this.drdtmaxamt = drdtmaxamt;
    }

    public BigDecimal getDrdtmaxcnt() {
        return drdtmaxcnt;
    }

    public void setDrdtmaxcnt(BigDecimal drdtmaxcnt) {
        this.drdtmaxcnt = drdtmaxcnt;
    }

    public BigDecimal getDrmtmaxamt() {
        return drmtmaxamt;
    }

    public void setDrmtmaxamt(BigDecimal drmtmaxamt) {
        this.drmtmaxamt = drmtmaxamt;
    }

    public BigDecimal getDrmtmaxcnt() {
        return drmtmaxcnt;
    }

    public void setDrmtmaxcnt(BigDecimal drmtmaxcnt) {
        this.drmtmaxcnt = drmtmaxcnt;
    }

    public BigDecimal getCrdtmaxamt() {
        return crdtmaxamt;
    }

    public void setCrdtmaxamt(BigDecimal crdtmaxamt) {
        this.crdtmaxamt = crdtmaxamt;
    }

    public BigDecimal getCrdtmaxcnt() {
        return crdtmaxcnt;
    }

    public void setCrdtmaxcnt(BigDecimal crdtmaxcnt) {
        this.crdtmaxcnt = crdtmaxcnt;
    }

    public BigDecimal getCrmtmaxamt() {
        return crmtmaxamt;
    }

    public void setCrmtmaxamt(BigDecimal crmtmaxamt) {
        this.crmtmaxamt = crmtmaxamt;
    }

    public BigDecimal getCrmtmaxcnt() {
        return crmtmaxcnt;
    }

    public void setCrmtmaxcnt(BigDecimal crmtmaxcnt) {
        this.crmtmaxcnt = crmtmaxcnt;
    }

    public Boolean getReglimitcusswitch() {
        return reglimitcusswitch;
    }

    public void setReglimitcusswitch(Boolean reglimitcusswitch) {
        this.reglimitcusswitch = reglimitcusswitch;
    }

    public Boolean getReglimitcaswitch() {
        return reglimitcaswitch;
    }

    public void setReglimitcaswitch(Boolean reglimitcaswitch) {
        this.reglimitcaswitch = reglimitcaswitch;
    }

    public String getOctype() {
        return octype;
    }

    public void setOctype(String octype) {
        this.octype = octype;
    }
}