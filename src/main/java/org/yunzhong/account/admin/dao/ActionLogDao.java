package org.yunzhong.account.admin.dao;

import com.coxcmn.jms.log.JMSLogMessage;

public class ActionLogDao extends AcctBasicDao<JMSLogMessage> {

    public int save(JMSLogMessage logMessage) {
        String sql = "INSERT INTO acctactionlog(USER,SESSION,ACTION,IP,CONTEXT, TYPE) VALUES(?,?,?,?,?,?)";
        return this.updateSQL(sql, logMessage.getUser(), logMessage.getSession(), logMessage.getAction(),
                logMessage.getIp(), logMessage.getContext(),logMessage.getType());
    }
}
