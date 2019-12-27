package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AcctCus;
import org.yunzhong.account.common.ServiceException;

public interface AcctCusService  extends AcctBasicService {

    public List<AcctCus> getAll(String osbType);
    
    public void delete(String osbType, String itemCode) throws ServiceException;

    public void update(AcctCus osb) throws ServiceException;

    public void add(AcctCus osb) throws ServiceException;
    
}
