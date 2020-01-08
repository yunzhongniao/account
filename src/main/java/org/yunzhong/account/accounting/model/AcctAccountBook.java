package org.yunzhong.account.accounting.model;

import java.util.Date;

public class AcctAccountBook {
    private String accountBookId;

    private String accountBookName;

    private String state;

    private String rootinstcd;

    private Date crtime;

    private String cruser;

    private Date shutuptime;

    private String shutupuser;

    private Date shutdowntime;

    private String shutdownuser;

    private String accountBookType;

    public String getAccountBookId() {
        return accountBookId;
    }

    public void setAccountBookId(String accountBookId) {
        this.accountBookId = accountBookId;
    }

    public String getAccountBookName() {
        return accountBookName;
    }

    public void setAccountBookName(String accountBookName) {
        this.accountBookName = accountBookName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRootinstcd() {
        return rootinstcd;
    }

    public void setRootinstcd(String rootinstcd) {
        this.rootinstcd = rootinstcd;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public Date getShutuptime() {
        return shutuptime;
    }

    public void setShutuptime(Date shutuptime) {
        this.shutuptime = shutuptime;
    }

    public String getShutupuser() {
        return shutupuser;
    }

    public void setShutupuser(String shutupuser) {
        this.shutupuser = shutupuser;
    }

    public Date getShutdowntime() {
        return shutdowntime;
    }

    public void setShutdowntime(Date shutdowntime) {
        this.shutdowntime = shutdowntime;
    }

    public String getShutdownuser() {
        return shutdownuser;
    }

    public void setShutdownuser(String shutdownuser) {
        this.shutdownuser = shutdownuser;
    }

    public String getAccountBookType() {
        return accountBookType;
    }

    public void setAccountBookType(String accountBookType) {
        this.accountBookType = accountBookType;
    }
}