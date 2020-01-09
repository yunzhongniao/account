package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.yunzhong.account.admin.dao.AuthPermDao;
import org.yunzhong.account.admin.dao.AuthRolePermDao;
import org.yunzhong.account.admin.model.AuthPerm;
import org.yunzhong.account.admin.model.AuthRolePerm;
import org.yunzhong.account.admin.service.AuthPermService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;
@Service
public class AuthPermServiceImpl implements AuthPermService {
    private static final Log log = LogFactory.getLog(AuthPermServiceImpl.class);
    
    private AuthPermDao authPermDao;
    
    private AuthRolePermDao authRolePermDao;
    
    public AuthPermDao getAuthPermDao() {
        return authPermDao;
    }

    public void setAuthPermDao(AuthPermDao authPermDao) {
        this.authPermDao = authPermDao;
    }

    public AuthRolePermDao getAuthRolePermDao() {
        return authRolePermDao;
    }

    public void setAuthRolePermDao(AuthRolePermDao authRolePermDao) {
        this.authRolePermDao = authRolePermDao;
    }

    @Override
    public List<AuthPerm> getAll() {
        return authPermDao.getAll();
    }
    
    @Override
    public List<AuthRolePerm> getByRoleId(int roleId) {
        return authRolePermDao.getByRoleId(roleId);
    }

    @Override
    public void delete(int permID) throws ServiceException {
        Long count = authRolePermDao.countPerm(permID);
        if (count != null && count > 0) {
            log.error("permID [" + permID + "] failed to be deleted,It has bean used in acctcus.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "权限在账户中使用，无法删除");
        }
        authPermDao.delete(permID);
    }

    @Override
    public void update(AuthPerm perm) throws ServiceException {
        if (perm == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = authPermDao.update(perm);
        if (row != 1) {
            log.error("PermName [" + perm.getPermName() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "权限更新异常");
        }
    }

    @Override
    public void add(AuthPerm perm) throws ServiceException {
        if (perm == null ) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = authPermDao.add(perm);
        if (row != 1) {
            log.error("PermName [" + perm.getPermName() + "] failed to be add,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "权限创建异常");
        }
    }
    
}
