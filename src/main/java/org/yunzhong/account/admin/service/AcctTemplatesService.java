package org.yunzhong.account.admin.service;

import org.yunzhong.account.admin.model.AcctTemplate;
import org.yunzhong.account.admin.model.Page;
import org.yunzhong.account.common.ServiceException;

public interface AcctTemplatesService extends AcctBasicService {

    public Page<AcctTemplate> search(String osbType, int pageNum, int pageSize);

    public void delete(Long tplId) throws ServiceException;

    public void update(AcctTemplate osb) throws ServiceException;

    public void add(AcctTemplate osb) throws ServiceException;
    
}
