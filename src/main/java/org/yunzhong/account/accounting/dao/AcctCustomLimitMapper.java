package org.yunzhong.account.accounting.dao;

import org.yunzhong.account.accounting.model.AcctCustomLimit;

public interface AcctCustomLimitMapper {
	int deleteByPrimaryKey(Long limitid);

	int insert(AcctCustomLimit record);

	int insertSelective(AcctCustomLimit record);

	AcctCustomLimit selectByPrimaryKey(Long limitid);

	int updateByPrimaryKeySelective(AcctCustomLimit record);

	int updateByPrimaryKey(AcctCustomLimit record);
}