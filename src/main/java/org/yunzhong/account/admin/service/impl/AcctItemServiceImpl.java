package org.yunzhong.account.admin.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import org.yunzhong.account.admin.dao.AcctCusDao;
import org.yunzhong.account.admin.dao.AcctEFDao;
import org.yunzhong.account.admin.dao.AcctItemDao;
import org.yunzhong.account.admin.dao.AcctTemplatesDao;
import org.yunzhong.account.admin.dao.AcctdiaryDao;
import org.yunzhong.account.admin.dao.CaGenledDao;
import org.yunzhong.account.admin.dao.OrgDao;
import org.yunzhong.account.admin.model.AcctItem;
import org.yunzhong.account.admin.model.Cagenled;
import org.yunzhong.account.admin.model.Organization;
import org.yunzhong.account.admin.service.AcctItemService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

public class AcctItemServiceImpl implements AcctItemService {
    private static final Log log = LogFactory.getLog(AcctItemServiceImpl.class);
    
    private AcctItemDao itemDao;
    
    private AcctCusDao cusDao;
    
    private AcctdiaryDao diaryDao;
    
    private AcctEFDao efDao;
    
    private AcctTemplatesDao templateDao;
    
    private Map<String, AcctItem> itemsLevel1;
    
    private CaGenledDao caGenledDao;
    
    private OrgDao orgDao;
    
    public AcctCusDao getCusDao() {
        return cusDao;
    }

    public void setCusDao(AcctCusDao cusDao) {
        this.cusDao = cusDao;
    }

    public AcctdiaryDao getDiaryDao() {
        return diaryDao;
    }

    public void setDiaryDao(AcctdiaryDao diaryDao) {
        this.diaryDao = diaryDao;
    }

    public AcctEFDao getEfDao() {
        return efDao;
    }

    public void setEfDao(AcctEFDao efDao) {
        this.efDao = efDao;
    }

    public AcctTemplatesDao getTemplateDao() {
        return templateDao;
    }

    public void setTemplateDao(AcctTemplatesDao templateDao) {
        this.templateDao = templateDao;
    }
    
    public Map<String, AcctItem> getItemsLevel1() {
        return itemsLevel1;
    }

    public void setItemsLevel1(Map<String, AcctItem> itemsLevel1) {
        this.itemsLevel1 = itemsLevel1;
    }

    public CaGenledDao getCaGenledDao() {
        return caGenledDao;
    }

    public void setCaGenledDao(CaGenledDao caGenledDao) {
        this.caGenledDao = caGenledDao;
    }
    
    public OrgDao getOrgDao() {
        return orgDao;
    }

    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }

    @Override
    public List<AcctItem> getAll(String osbType) {
        return itemDao.getAll(osbType, null);
    }
    
    @Override
    public List<AcctItem> getNotAddLevel1Items(String osbType) {
        List<AcctItem> naItems = itemDao.getLevel1Item(osbType);
        List<String> naItemCodes = new ArrayList<>();
        naItems.forEach(item -> naItemCodes.add(item.getItemCode()));
        
        List<AcctItem> items = new ArrayList<>();
        Set<String> itemSet = itemsLevel1.keySet();
        itemSet.forEach(item -> {
            if(!naItemCodes.contains(item)) {
                AcctItem ai = itemsLevel1.get(item);
                ai.setOsbType(osbType);
                items.add(ai);
            }
        });
        
        Collections.sort(items);
        return items;
    }
    
    @Override
    public void delete(String osbType, String itemCode) throws ServiceException {
        //校验acctcus，caacctdiary，caacctef,caaccttpl
        Long countItem = cusDao.countItem(osbType, itemCode);
        if (countItem != null && countItem > 0) {
            log.error("item [" + itemCode + "] failed to be deleted,It has bean used in acctcus.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "会计科目在账户中使用，无法删除");
        }
        Long diaryCount = diaryDao.countItem(osbType, itemCode);
        if (diaryCount != null && diaryCount > 0) {
            log.error("item [" + itemCode + "] failed to be deleted,It has bean used in diary.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "会计科目在账户日表中使用，无法删除");
        }
        Long efCount = efDao.countItem(osbType, itemCode);
        if (efCount != null && efCount > 0) {
            log.error("item [" + itemCode + "] failed to be deleted,It has bean used in ef.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "会计科目在分录规则中使用，无法删除");
        }
        Long tplCount = templateDao.countItem(osbType, itemCode);
        if (tplCount != null && tplCount > 0) {
            log.error("item [" + itemCode + "] failed to be deleted,It has bean used in template.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "会计科目在模板中使用，无法删除");
        }
        itemDao.delete(osbType,itemCode);
        
        List<Organization> osbs = orgDao.getByOSBType(osbType);
        for (Organization osb : osbs) {
            caGenledDao.delete(osb.getOsbId(), itemCode);
        }
    }

    @Override
    public void update(AcctItem item) throws ServiceException {
        if (item == null) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = itemDao.update(item);
        if (row != 1) {
            log.error("item [" + item.getItemName() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "会计科目更新异常");
        }
        
        List<Organization> osbs = orgDao.getByOSBType(item.getOsbType());
        List<Cagenled> cagenleds = new ArrayList<>();
        for (Organization osb : osbs) {
            Cagenled cagenled = getCagenled(item, osb.getOsbId());
            cagenleds.add(cagenled);
        }
        caGenledDao.batchUpdate(cagenleds);
    }

    @Override
    public void add(AcctItem item) throws ServiceException {
        if (item == null ) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        int row = itemDao.add(item);
        if (row != 1) {
            log.error("item [" + item.getItemName() + "] failed to be updated,effected rows [" + row + "].");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "会计明细创建异常");
        }
        List<Organization> osbs = orgDao.getByOSBType(item.getOsbType());
        List<Cagenled> cagenleds = new ArrayList<>();
        for (Organization osb : osbs) {
            Cagenled cagenled = getCagenled(item, osb.getOsbId());
            cagenleds.add(cagenled);
        }
        caGenledDao.batchAdd(cagenleds);
    }
    
    private Cagenled getCagenled(AcctItem item, String osbId) {
        Cagenled caGenled = new Cagenled();
        caGenled.setOsbID(osbId);
        caGenled.setItemCode(item.getItemCode());
        caGenled.setItemClass(item.getItemClass());
        caGenled.setItemBalby(item.getItemBalby());
        caGenled.setCurrType(item.getCurrType());
        return caGenled;
    }
    
    @Override
    public void addByItemCodes(String osbType, String itemCodes) throws ServiceException {
        if (StringUtils.isEmpty(itemCodes)) {
            log.error("empty param.");
            throw new ServiceException(CphErrorCode.ERR_CODE_CA_PARAMNOTALLOW, "参数为空");
        }
        
        String[] itemCodeArr = itemCodes.split(",");
        List<AcctItem> items = new ArrayList<>();
        List<Organization> osbs = orgDao.getByOSBType(osbType);
        List<Cagenled> cagenleds = new ArrayList<>();
        for (String itemCode : itemCodeArr) {
            AcctItem item = itemsLevel1.get(itemCode);
            item.setOsbType(osbType);
            items.add(item);
            for (Organization osb : osbs) {
                Cagenled cagenled = getCagenled(item, osb.getOsbId());
                cagenleds.add(cagenled);
            }
        }
        
        itemDao.batchAdd(items);
        caGenledDao.batchAdd(cagenleds);
    }

    public AcctItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(AcctItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public List<AcctItem> getAll(String osbType, Integer itemClass) {
        return itemDao.getAll(osbType, itemClass);
    }

    
}
