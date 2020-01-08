package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.yunzhong.account.accounting.model.AcctEntryRuleDetail;

public interface AcctEntryRuleDetailMapper {
    int deleteByPrimaryKey(Long efid);

    int insert(AcctEntryRuleDetail record);

    AcctEntryRuleDetail selectByPrimaryKey(Long efid);

    List<AcctEntryRuleDetail> selectAll();

    int updateByPrimaryKey(AcctEntryRuleDetail record);
}