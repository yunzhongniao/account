package org.yunzhong.account.admin.model.jms;

import java.util.Date;

/**
 * @author yunzhong
 *
 */
public class JMSLogMessage {

    private String context;
    private String ip;
    private String action;
    private String session;
    private String user;
    private Date timestamp;
    
    /**
     * user:用户操作。manager：系统管理员操作
     */
    private String type;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
