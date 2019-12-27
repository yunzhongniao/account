package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.OrgSalesBook;
import org.yunzhong.account.common.ServiceException;

public interface OSBService extends AcctBasicService {

    public List<OrgSalesBook> getAll();

    public void delete(String osbType) throws ServiceException;

    public void update(OrgSalesBook osb) throws ServiceException;

    public void add(OrgSalesBook osb) throws ServiceException;
    
}
