package org.yunzhong.account.admin.vo;

import org.yunzhong.account.common.ValidateUtil;

public class ReqHead {

    private String infcode;

    private String version;

    private String datatype;

    private String level;

    private String userosbid;

    private String appid;

    private String username;

    private String userpass;

    private String signedmsg;

    private String sign;

    private long timestamp;

    public ReqHead() {
    }

    public String getInfcode() {
        return infcode;
    }

    public void setInfcode(String infcode) {
        this.infcode = infcode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getUserosbid() {
        return userosbid;
    }

    public void setUserosbid(String userosbid) {
        this.userosbid = userosbid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getSignedmsg() {
        return signedmsg;
    }

    public void setSignedmsg(String signedmsg) {
        this.signedmsg = signedmsg;
    }

    public void checkReqHead() throws Exception {
        String msgprefix = "请求报文头";
        if (!ValidateUtil.validateStaticData(this.getVersion(), true, "01"))
            throw new Exception(msgprefix + "版本号格式非法");
        if (!ValidateUtil.validateStaticData(this.getDatatype(), true, "1"))
            throw new Exception(msgprefix + "数据格式格式非法");
        if (!ValidateUtil.validateN(this.getLevel(), true, 1, 1))
            throw new Exception(msgprefix + "处理级别格式非法");
        if (!ValidateUtil.validateVC(this.getUserosbid(), true, 1, 10))
            throw new Exception(msgprefix + "发起方所属机构号格式非法");
        if (!ValidateUtil.validateVC(this.getAppid(), true, 1, 20))
            throw new Exception(msgprefix + "发起方所属应用编号格式非法");
        if (!ValidateUtil.validateVC(this.getUsername(), true, 1, 20))
            throw new Exception(msgprefix + "发起方用户名格式非法");
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
