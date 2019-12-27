package org.yunzhong.account.admin.model;

import java.util.Date;

public class Organization extends AcctBasicEntity {
    private String osbId;
    private String sbName;
    private int state;
    private Date crTime;
    private String crUser;
    private Date shutupTime;
    private String shutupUser;
    private Date shutdownTime;
    private String shutdownUser;
    private String osbType;

    private AppInfo appInfo;
    
    public String getOsbId() {
        return osbId;
    }

    public void setOsbId(String osbId) {
        this.osbId = osbId;
    }

    public String getSbName() {
        return sbName;
    }

    public void setSbName(String sbName) {
        this.sbName = sbName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }

    public String getCrUser() {
        return crUser;
    }

    public void setCrUser(String crUser) {
        this.crUser = crUser;
    }

    public Date getShutupTime() {
        return shutupTime;
    }

    public void setShutupTime(Date shutupTime) {
        this.shutupTime = shutupTime;
    }

    public String getShutupUser() {
        return shutupUser;
    }

    public void setShutupUser(String shutupUser) {
        this.shutupUser = shutupUser;
    }

    public Date getShutdownTime() {
        return shutdownTime;
    }

    public void setShutdownTime(Date shutdownTime) {
        this.shutdownTime = shutdownTime;
    }

    public String getShutdownUser() {
        return shutdownUser;
    }

    public void setShutdownUser(String shutdownUser) {
        this.shutdownUser = shutdownUser;
    }

    public String getOsbType() {
        return osbType;
    }

    public void setOsbType(String osbType) {
        this.osbType = osbType;
    }

    public AppInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(AppInfo appInfo) {
        this.appInfo = appInfo;
    }
}
