package org.yunzhong.account.admin.service;

import org.yunzhong.account.admin.model.AppUser;
import org.yunzhong.account.admin.model.Page;
import org.yunzhong.account.common.ServiceException;

public interface UserService extends AcctBasicService {

    public AppUser checkUser(AppUser user);
    
    public Page<AppUser> search(Long appId, int pageNum, int pageSize);

    public void delete(Long appId, String userId) throws ServiceException;

    public void update(AppUser user) throws ServiceException;

    public void add(AppUser user) throws ServiceException;

    public void appendRole(AppUser user) throws ServiceException;

    public void removeRole(AppUser user) throws ServiceException;
}
