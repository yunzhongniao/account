package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.CurrType;
import org.yunzhong.account.common.ServiceException;

public interface CurrTypeService extends AcctBasicService {

    public List<CurrType> getAll();
    
    public void delete(String currType) throws ServiceException;

    public void update(CurrType currType) throws ServiceException;

    public void add(CurrType currType) throws ServiceException;
    
}
