package org.yunzhong.account.accounting.dao;

import org.yunzhong.account.accounting.model.AcctEntryRuleDetail;

public interface AcctEntryRuleDetailMapper {
    int deleteByPrimaryKey(Long efid);

    int insert(AcctEntryRuleDetail record);

    int insertSelective(AcctEntryRuleDetail record);

    AcctEntryRuleDetail selectByPrimaryKey(Long efid);

    int updateByPrimaryKeySelective(AcctEntryRuleDetail record);

    int updateByPrimaryKey(AcctEntryRuleDetail record);
}