package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AuthPerm;
import org.yunzhong.account.admin.model.AuthRolePerm;
import org.yunzhong.account.common.ServiceException;

public interface AuthPermService extends AcctBasicService {

    public List<AuthPerm> getAll();
    
    public List<AuthRolePerm> getByRoleId(int roleId);
    
    public void delete(int permID) throws ServiceException;

    public void update(AuthPerm perm) throws ServiceException;

    public void add(AuthPerm perm) throws ServiceException;
    
}
