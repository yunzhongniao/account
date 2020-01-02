package org.yunzhong.account.admin.service;

import java.util.List;

import org.yunzhong.account.admin.model.AuthRole;
import org.yunzhong.account.admin.model.Page;
import org.yunzhong.account.common.ServiceException;

public interface RoleService extends AcctBasicService {

    public Page<AuthRole> search(int pageNum, int pageSize);

    public void delete(Integer appId) throws ServiceException;

    public void update(AuthRole user) throws ServiceException;

    public void add(AuthRole user) throws ServiceException;

    public void appendPerm(AuthRole user) throws ServiceException;

    public void removePerm(AuthRole user) throws ServiceException;

    public List<AuthRole> list(Long appId, String userId);

    public List<AuthRole> getAll();
}
