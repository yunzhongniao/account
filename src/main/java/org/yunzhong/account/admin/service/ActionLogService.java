package org.yunzhong.account.admin.service;

import org.yunzhong.account.admin.model.jms.JMSLogMessage;

public interface ActionLogService {

    void save(JMSLogMessage message);
}
