package org.yunzhong.account.accounting.dao;

import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctGenledDetail;

public interface AcctGenledDetailMapper {
	int deleteByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("itemcode") String itemcode,
			@Param("periodday") String periodday);

	int insert(AcctGenledDetail record);

	int insertSelective(AcctGenledDetail record);

	AcctGenledDetail selectByPrimaryKey(@Param("accountBookId") String accountBookId,
			@Param("itemcode") String itemcode, @Param("periodday") String periodday);

	int updateByPrimaryKeySelective(AcctGenledDetail record);

	int updateByPrimaryKey(AcctGenledDetail record);
}