package org.yunzhong.account.admin.model;

import java.util.List;

public class AcctEFGroup {

    private String osbType;
    /**
     * 存放osbId
     */
    private String pid;
    private String efName;
    private String trxDir;
    private String trxCode;
    private String actionX;
    
    private List<AcctEF> acctEFs;

    public String getEfName() {
        return efName;
    }

    public void setEfName(String efName) {
        this.efName = efName;
    }

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public String getOsbType() {
        return osbType;
    }

    public void setOsbType(String osbType) {
        this.osbType = osbType;
    }

    public List<AcctEF> getAcctEFs() {
        return acctEFs;
    }

    public void setAcctEFs(List<AcctEF> acctEFs) {
        this.acctEFs = acctEFs;
    }

    public String getTrxDir() {
        return trxDir;
    }

    public void setTrxDir(String trxDir) {
        this.trxDir = trxDir;
    }

    public String getActionX() {
        return actionX;
    }

    public void setActionX(String actionX) {
        this.actionX = actionX;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

}
