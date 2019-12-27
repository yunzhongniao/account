package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AcctCusInfo;
import org.yunzhong.account.common.ServiceException;

public interface AcctCusInfoService  extends AcctBasicService {

    public List<AcctCusInfo> getAll();
    
    public void delete(String cusId, String osbId) throws ServiceException;

    public void add(AcctCusInfo cusInfo) throws ServiceException;
    
    public AcctCusInfo getOne(String cusId, String osbId) throws ServiceException;
    
}
