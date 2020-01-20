package org.yunzhong.account.accounting.dao;

import org.yunzhong.account.accounting.model.AcctAccountBookType;

public interface AcctAccountBookTypeMapper {
	int deleteByPrimaryKey(String accountBookType);

	int insert(AcctAccountBookType record);

	int insertSelective(AcctAccountBookType record);

	AcctAccountBookType selectByPrimaryKey(String accountBookType);

	int updateByPrimaryKeySelective(AcctAccountBookType record);

	int updateByPrimaryKey(AcctAccountBookType record);
}