package org.yunzhong.account.admin.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yunzhong.account.admin.dao.AcctTemplatesDao;
import org.yunzhong.account.admin.model.AcctTemplate;
import org.yunzhong.account.admin.model.Page;
import org.yunzhong.account.admin.service.AcctTemplatesService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class AcctTemplatesServiceImpl implements AcctTemplatesService {
    private static Log log = LogFactory.getLog(AcctTemplatesServiceImpl.class);

    private AcctTemplatesDao templatesDao;

    @Override
    public Page<AcctTemplate> search(String osbType, int pageNum, int pageSize) {
        long count = templatesDao.count(osbType);
        if (count <= 0) {
            log.warn("There are no templates of osb type [" + osbType + "]");
            return new Page<>();
        }
        Page<AcctTemplate> page = new Page<>();
        page.setData(templatesDao.search(osbType, pageNum, pageSize));
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setiTotalDisplayRecords(count);
        return page;
    }

    @Override
    public void delete(Long tplId) throws ServiceException {
        int row = templatesDao.delete(tplId);
        if (row != 1) {
            log.error("template [" + tplId + "] failed to be deleted,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账号模板删除异常");
        }
    }

    @Override
    public void update(AcctTemplate template) throws ServiceException {
        if (template == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = templatesDao.update(template);
        if (row != 1) {
            log.error("template [" + template.getTplName() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账号模板更新异常");
        }

    }

    @Override
    public void add(AcctTemplate template) throws ServiceException {
        if (template == null ) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = templatesDao.add(template);
        if (row != 1) {
            log.error("template [" + template.getTplName() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "账号模板创建异常");
        }
    }

    public AcctTemplatesDao getTemplatesDao() {
        return templatesDao;
    }

    public void setTemplatesDao(AcctTemplatesDao templatesDao) {
        this.templatesDao = templatesDao;
    }

}
