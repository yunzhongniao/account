package org.yunzhong.account.admin.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.yunzhong.account.admin.dao.OSBDao;
import org.yunzhong.account.admin.dao.OrgDao;
import org.yunzhong.account.admin.model.OrgSalesBook;
import org.yunzhong.account.admin.model.Organization;
import org.yunzhong.account.admin.service.OSBService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class OSBServiceImpl implements OSBService {
    private static Log log = LogFactory.getLog(OSBServiceImpl.class);

    private OSBDao osbDao;
    private OrgDao orgDao;

    public OSBDao getOsbDao() {
        return osbDao;
    }

    public void setOsbDao(OSBDao osbDao) {
        this.osbDao = osbDao;
    }

    public OrgDao getOrgDao() {
        return orgDao;
    }

    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }

    @Override
    public List<OrgSalesBook> getAll() {
        return osbDao.getAll();
    }

    @Override
    @Transactional
    public void delete(String osbType) throws ServiceException {
        List<Organization> orgs = orgDao.getByOSBType(osbType);
        if (!CollectionUtils.isEmpty(orgs)) {
            log.error("osbType [" + osbType + "] has been used,can not be deleted.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账套已使用，无法删除");
        }
        int row = osbDao.delete(osbType);
        if (row != 1) {
            log.error("osbType [" + osbType + "] failed to be deleted,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账套删除异常");
        }
    }

    @Override
    @Transactional
    public void update(OrgSalesBook osb) throws ServiceException {
        if (osb == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = osbDao.update(osb);
        if (row != 1) {
            log.error("osbType [" + osb.getOsbType() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账套更新异常");
        }

    }

    @Override
    @Transactional
    public void add(OrgSalesBook osb) throws ServiceException {
        if (osb == null || StringUtils.isEmpty(osb.getOsbName()) || StringUtils.isEmpty(osb.getOsbType())) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = osbDao.add(osb);
        if (row != 1) {
            log.error("osbType [" + osb.getOsbType() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账套更新异常");
        }
    }

}
