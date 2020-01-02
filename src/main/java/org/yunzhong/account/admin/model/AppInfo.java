package org.yunzhong.account.admin.model;

public class AppInfo extends AcctBasicEntity {

    private Long appId;
    private String appName;
    private String osbId;

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getOsbId() {
        return osbId;
    }

    public void setOsbId(String osbId) {
        this.osbId = osbId;
    }

}
