package org.yunzhong.account.admin.model;

public class PageSearch {
    private int page;
    private int pageSize;
    private String osbType;
    private Long appId;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOsbType() {
        return osbType;
    }

    public void setOsbType(String osbType) {
        this.osbType = osbType;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

}
