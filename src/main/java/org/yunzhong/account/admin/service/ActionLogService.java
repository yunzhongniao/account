package org.yunzhong.account.admin.service;

import com.coxcmn.jms.log.JMSLogMessage;

public interface ActionLogService {

    void save(JMSLogMessage message);
}
