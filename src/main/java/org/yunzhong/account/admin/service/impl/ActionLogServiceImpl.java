package org.yunzhong.account.admin.service.impl;

import org.springframework.stereotype.Service;
import org.yunzhong.account.admin.dao.ActionLogDao;
import org.yunzhong.account.admin.model.jms.JMSLogMessage;
import org.yunzhong.account.admin.service.ActionLogService;
@Service
public class ActionLogServiceImpl implements ActionLogService {

    private ActionLogDao logDao;
    
    @Override
    public void save(JMSLogMessage message) {
        logDao.save(message);
    }

    public ActionLogDao getLogDao() {
        return logDao;
    }

    public void setLogDao(ActionLogDao logDao) {
        this.logDao = logDao;
    }

}
