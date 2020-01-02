package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.yunzhong.account.admin.dao.AuthRoleDao;
import org.yunzhong.account.admin.model.AuthRole;
import org.yunzhong.account.admin.model.Page;
import org.yunzhong.account.admin.service.RoleService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class RoleServiceImpl implements RoleService {
    private static final Log log = LogFactory.getLog(RoleServiceImpl.class);

    private AuthRoleDao roleDao;

    public AuthRoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(AuthRoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Page<AuthRole> search(int pageNum, int pageSize) {
        long count = roleDao.count();
        if (count <= 0) {
            log.warn("There are no roles");
            return new Page<>();
        }
        Page<AuthRole> page = new Page<>();
        page.setData(roleDao.search(pageNum, pageSize));
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setiTotalDisplayRecords(count);
        return page;
    }

    @Override
    @Transactional
    public void delete(Integer roleId) throws ServiceException {
        // check userrole
        Long usedCount = this.roleDao.countRole(roleId);
        if (usedCount != null && usedCount > 0) {
            log.error("role [" + roleId + "] failed to be deleted,It has bean used.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "角色已经使用，无法删除");
        }
        this.roleDao.delete(roleId);
    }

    @Override
    public void update(AuthRole role) throws ServiceException {
        if (role == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = roleDao.update(role);
        if (row != 1) {
            log.error("user [" + role.getRoleID() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "角色更新异常");
        }
    }

    @Override
    public void add(AuthRole role) throws ServiceException {
        if (role == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = roleDao.add(role);
        if (row != 1) {
            log.error("user [" + role.getRoleID() + "] failed to be added,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "角色创建异常");
        }
    }

    @Override
    public void appendPerm(AuthRole role) throws ServiceException {
        if (role == null || CollectionUtils.isEmpty(role.getPerms())) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        roleDao.appendPerm(role.getRoleID(), role.getPerms());
    }

    @Override
    public void removePerm(AuthRole role) throws ServiceException {
        if (role == null || CollectionUtils.isEmpty(role.getPerms())) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        roleDao.removePerm(role.getRoleID(), role.getPerms());
    }

    @Override
    public List<AuthRole> list(Long appId, String userId) {
        return roleDao.list(appId, userId);
    }

    @Override
    public List<AuthRole> getAll() {
        return roleDao.getAll();
    }
}
