package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AcctType;
import org.yunzhong.account.common.ServiceException;

public interface AcctTypeService extends AcctBasicService {

    public List<AcctType> getAll(String osbType);

    public void delete(String osbType,String acctType) throws ServiceException;

    public void update(AcctType osb) throws ServiceException;

    public void add(AcctType osb) throws ServiceException;
    
}
