package org.yunzhong.account.admin.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.yunzhong.account.admin.dao.UserDao;
import org.yunzhong.account.admin.model.AppUser;
import org.yunzhong.account.admin.service.UserService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class UserServiceImpl implements UserService {
    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    private UserDao userDao;

    public AppUser checkUser(AppUser user) {
        return userDao.checkUser(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Page<AppUser> search(Long appId, int pageNum, int pageSize) {
        long count = userDao.countApp(appId);
        if (count <= 0) {
            log.warn("There are no users of app [" + appId + "]");
            return new Page<>();
        }
        Page<AppUser> page = new Page<>();
        page.setData(userDao.search(appId, pageNum, pageSize));
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setiTotalDisplayRecords(count);
        return page;
    }

    @Override
    @Transactional
    public void delete(Long appId, String userId) throws ServiceException {
        this.userDao.delete(appId, userId);
        this.userDao.deleteUserRole(appId, userId);
    }

    @Override
    public void update(AppUser user) throws ServiceException {
        if (user == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = userDao.update(user);
        if (row != 1) {
            log.error("user [" + user.getUserId() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "用户更新异常");
        }
    }

    @Override
    public void add(AppUser user) throws ServiceException {
        if (user == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = userDao.add(user);
        if (row != 1) {
            log.error("user [" + user.getUserId() + "] failed to be added,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "用户创建异常");
        }
    }

    @Override
    public void appendRole(AppUser user) throws ServiceException {
        if (user == null || CollectionUtils.isEmpty(user.getRoles())) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        userDao.appendRole(user.getUserId(),user.getAppId(), user.getRoles());
    }
    
    @Override
    public void removeRole(AppUser user) throws ServiceException {
        if (user == null || CollectionUtils.isEmpty(user.getRoles())) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        userDao.removeRole(user.getUserId(),user.getAppId(), user.getRoles());
    }
}
