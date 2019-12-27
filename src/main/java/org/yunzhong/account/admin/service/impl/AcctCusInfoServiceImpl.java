package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.yunzhong.account.admin.dao.AcctCusInfoDao;
import org.yunzhong.account.admin.model.AcctCusInfo;
import org.yunzhong.account.admin.service.AcctCusInfoService;
import org.yunzhong.account.common.ServiceException;

public class AcctCusInfoServiceImpl implements AcctCusInfoService {

    private AcctCusInfoDao acctCusInfoDao;

    public AcctCusInfoDao getAcctCusInfoDao() {
        return acctCusInfoDao;
    }

    public void setAcctCusInfoDao(AcctCusInfoDao acctCusInfoDao) {
        this.acctCusInfoDao = acctCusInfoDao;
    }

    @Override
    public List<AcctCusInfo> getAll() {
        return acctCusInfoDao.getAll();
    }

    @Override
    public void delete(String cusId, String osbId) throws ServiceException {
        acctCusInfoDao.delete(cusId, osbId);
    }

    @Override
    public void add(AcctCusInfo cusInfo) throws ServiceException {
        acctCusInfoDao.add(cusInfo);
    }

    @Override
    public AcctCusInfo getOne(String cusId, String osbId) throws ServiceException {
        return acctCusInfoDao.getOne(cusId, osbId);
    }
    

}
