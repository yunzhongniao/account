package org.yunzhong.account.accounting.model;

import java.math.BigDecimal;
import java.util.Date;

public class AcctEntryDetail {
    private String voucherno;

    private Long entryno;

    private String accountBookId;

    private Long entrypty;

    private String vouchertype;

    private Byte iscusacct;

    private String acctno;

    private String currtype;

    private String pid;

    private String trxcode;

    private String trxid;

    private String refvoucherno;

    private String parenttrxid;

    private String childtrxid;

    private String entrydate;

    private Date entrytime;

    private Byte crdr;

    private BigDecimal amount;

    private BigDecimal curbal;

    private String reciporgtype;

    private String reciporgcode;

    private String recipacctno;

    private Byte postflag;

    private String postdate;

    private Date posttime;

    private String postbatch;

    private Byte genledflag;

    private String genleddate;

    private Date genledtime;

    private String genledbatch;

    private String memo;

    private Byte isrevd;

    private Byte entrytype;

    private Date revtime;

    private Byte revtype;

    private Long entrybatch;

    private String acctname;

    private BigDecimal reglimitcus;

    private BigDecimal reglimitca;

    private Boolean reglimitacct;

    private String accttype;

    private String id;

    public String getVoucherno() {
        return voucherno;
    }

    public void setVoucherno(String voucherno) {
        this.voucherno = voucherno;
    }

    public Long getEntryno() {
        return entryno;
    }

    public void setEntryno(Long entryno) {
        this.entryno = entryno;
    }

    public String getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(String accountBookId) {
        this.accountBookId = accountBookId;
    }

    public Long getEntrypty() {
        return entrypty;
    }

    public void setEntrypty(Long entrypty) {
        this.entrypty = entrypty;
    }

    public String getVouchertype() {
        return vouchertype;
    }

    public void setVouchertype(String vouchertype) {
        this.vouchertype = vouchertype;
    }

    public Byte getIscusacct() {
        return iscusacct;
    }

    public void setIscusacct(Byte iscusacct) {
        this.iscusacct = iscusacct;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getCurrtype() {
        return currtype;
    }

    public void setCurrtype(String currtype) {
        this.currtype = currtype;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTrxcode() {
        return trxcode;
    }

    public void setTrxcode(String trxcode) {
        this.trxcode = trxcode;
    }

    public String getTrxid() {
        return trxid;
    }

    public void setTrxid(String trxid) {
        this.trxid = trxid;
    }

    public String getRefvoucherno() {
        return refvoucherno;
    }

    public void setRefvoucherno(String refvoucherno) {
        this.refvoucherno = refvoucherno;
    }

    public String getParenttrxid() {
        return parenttrxid;
    }

    public void setParenttrxid(String parenttrxid) {
        this.parenttrxid = parenttrxid;
    }

    public String getChildtrxid() {
        return childtrxid;
    }

    public void setChildtrxid(String childtrxid) {
        this.childtrxid = childtrxid;
    }

    public String getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(String entrydate) {
        this.entrydate = entrydate;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Byte getCrdr() {
        return crdr;
    }

    public void setCrdr(Byte crdr) {
        this.crdr = crdr;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCurbal() {
        return curbal;
    }

    public void setCurbal(BigDecimal curbal) {
        this.curbal = curbal;
    }

    public String getReciporgtype() {
        return reciporgtype;
    }

    public void setReciporgtype(String reciporgtype) {
        this.reciporgtype = reciporgtype;
    }

    public String getReciporgcode() {
        return reciporgcode;
    }

    public void setReciporgcode(String reciporgcode) {
        this.reciporgcode = reciporgcode;
    }

    public String getRecipacctno() {
        return recipacctno;
    }

    public void setRecipacctno(String recipacctno) {
        this.recipacctno = recipacctno;
    }

    public Byte getPostflag() {
        return postflag;
    }

    public void setPostflag(Byte postflag) {
        this.postflag = postflag;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getPostbatch() {
        return postbatch;
    }

    public void setPostbatch(String postbatch) {
        this.postbatch = postbatch;
    }

    public Byte getGenledflag() {
        return genledflag;
    }

    public void setGenledflag(Byte genledflag) {
        this.genledflag = genledflag;
    }

    public String getGenleddate() {
        return genleddate;
    }

    public void setGenleddate(String genleddate) {
        this.genleddate = genleddate;
    }

    public Date getGenledtime() {
        return genledtime;
    }

    public void setGenledtime(Date genledtime) {
        this.genledtime = genledtime;
    }

    public String getGenledbatch() {
        return genledbatch;
    }

    public void setGenledbatch(String genledbatch) {
        this.genledbatch = genledbatch;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Byte getIsrevd() {
        return isrevd;
    }

    public void setIsrevd(Byte isrevd) {
        this.isrevd = isrevd;
    }

    public Byte getEntrytype() {
        return entrytype;
    }

    public void setEntrytype(Byte entrytype) {
        this.entrytype = entrytype;
    }

    public Date getRevtime() {
        return revtime;
    }

    public void setRevtime(Date revtime) {
        this.revtime = revtime;
    }

    public Byte getRevtype() {
        return revtype;
    }

    public void setRevtype(Byte revtype) {
        this.revtype = revtype;
    }

    public Long getEntrybatch() {
        return entrybatch;
    }

    public void setEntrybatch(Long entrybatch) {
        this.entrybatch = entrybatch;
    }

    public String getAcctname() {
        return acctname;
    }

    public void setAcctname(String acctname) {
        this.acctname = acctname;
    }

    public BigDecimal getReglimitcus() {
        return reglimitcus;
    }

    public void setReglimitcus(BigDecimal reglimitcus) {
        this.reglimitcus = reglimitcus;
    }

    public BigDecimal getReglimitca() {
        return reglimitca;
    }

    public void setReglimitca(BigDecimal reglimitca) {
        this.reglimitca = reglimitca;
    }

    public Boolean getReglimitacct() {
        return reglimitacct;
    }

    public void setReglimitacct(Boolean reglimitacct) {
        this.reglimitacct = reglimitacct;
    }

    public String getAccttype() {
        return accttype;
    }

    public void setAccttype(String accttype) {
        this.accttype = accttype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}