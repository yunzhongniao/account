package org.yunzhong.account.admin.model;

/**
 * 币种类型
 * @author kevin.gong
 * @Time 2018年3月15日 上午9:25:39
 */
public class CurrType extends AcctBasicEntity {
    //币种代码
    private String currType;
    //币种名称
    private String currName;
    //本币标识
    private String currLocal;
    
    public String getCurrType() {
        return currType;
    }
    public void setCurrType(String currType) {
        this.currType = currType;
    }
    public String getCurrName() {
        return currName;
    }
    public void setCurrName(String currName) {
        this.currName = currName;
    }
    public String getCurrLocal() {
        return currLocal;
    }
    public void setCurrLocal(String currLocal) {
        this.currLocal = currLocal;
    }
}
