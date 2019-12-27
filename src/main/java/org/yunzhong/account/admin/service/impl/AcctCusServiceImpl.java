package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.yunzhong.account.admin.dao.AcctCusDao;
import org.yunzhong.account.admin.model.AcctCus;
import org.yunzhong.account.admin.service.AcctCusService;
import org.yunzhong.account.common.ServiceException;

public class AcctCusServiceImpl implements AcctCusService {

    private AcctCusDao cusDao;
    
    @Override
    public List<AcctCus> getAll(String osbType) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String osbType, String itemCode) throws ServiceException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(AcctCus osb) throws ServiceException {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(AcctCus osb) throws ServiceException {
        // TODO Auto-generated method stub

    }

    public AcctCusDao getCusDao() {
        return cusDao;
    }

    public void setCusDao(AcctCusDao cusDao) {
        this.cusDao = cusDao;
    }

}
