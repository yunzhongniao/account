package org.yunzhong.account.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;
import org.yunzhong.account.admin.dao.AcctEFDao;
import org.yunzhong.account.admin.model.AcctEF;
import org.yunzhong.account.admin.model.AcctEFGroup;
import org.yunzhong.account.admin.service.AcctEFService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class AcctEFServiceImpl implements AcctEFService {
    private static final Log log = LogFactory.getLog(AcctEFServiceImpl.class);
    private AcctEFDao efDao;

    public AcctEFDao getEfDao() {
        return efDao;
    }

    public void setEfDao(AcctEFDao efDao) {
        this.efDao = efDao;
    }

    @Override
    public List<AcctEF> getAll(String osbId) {
        return efDao.getAll(osbId);
    }

    @Override
    public void delete(AcctEFGroup acctEFGroup) {
        int row = efDao.delete(acctEFGroup.getPid(), acctEFGroup.getTrxCode());
        if (row <= 0) {
            log.warn("There are no acct entry of osb [" + acctEFGroup.getPid() + "] trxcode ["
                    + acctEFGroup.getTrxCode() + "]");
        }
    }

    @Override
    public void update(AcctEFGroup acctEFGroup) {
        if (CollectionUtils.isEmpty(acctEFGroup.getAcctEFs())) {
            log.error("Entry list is empty .");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "分录规则参数为空");
        }
        List<AcctEF> newEFs = new ArrayList<>();
        List<AcctEF> updateEFs = new ArrayList<>();
        acctEFGroup.getAcctEFs().forEach(ef -> {
            if (ef.getEfId() != null) {
                updateEFs.add(ef);
            } else {
                newEFs.add(ef);
            }
        });
        efDao.deleteOther(acctEFGroup.getPid(), acctEFGroup.getTrxCode(), updateEFs);
        if (!CollectionUtils.isEmpty(newEFs)) {
            efDao.batchAdd(newEFs);
        }
        if (!CollectionUtils.isEmpty(updateEFs)) {
            efDao.batchUpdate(updateEFs);
        }
    }

    @Override
    public void add(AcctEFGroup acctEFGroup) {
        if (CollectionUtils.isEmpty(acctEFGroup.getAcctEFs())) {
            log.error("Entry list is empty .");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "分录规则参数为空");
        }
        List<AcctEF> efs = efDao.select(acctEFGroup.getPid(), acctEFGroup.getTrxCode());
        if (!CollectionUtils.isEmpty(efs)) {
            log.error("There are efs of pid [" + acctEFGroup.getPid() + "] trxcode [" + acctEFGroup.getTrxCode() + "]");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW,
                    "分录规则" + acctEFGroup.getPid() + "," + acctEFGroup.getTrxCode() + "已经存在");
        }
        efDao.batchAdd(acctEFGroup.getAcctEFs());
    }

}
