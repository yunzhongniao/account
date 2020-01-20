package org.yunzhong.account.accounting.dao;

import org.yunzhong.account.accounting.model.AcctTransactionCat;

public interface AcctTransactionCatMapper {
	int deleteByPrimaryKey(String trxcode);

	int insert(AcctTransactionCat record);

	int insertSelective(AcctTransactionCat record);

	AcctTransactionCat selectByPrimaryKey(String trxcode);

	int updateByPrimaryKeySelective(AcctTransactionCat record);

	int updateByPrimaryKey(AcctTransactionCat record);
}