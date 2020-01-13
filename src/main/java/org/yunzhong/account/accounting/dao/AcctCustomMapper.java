package org.yunzhong.account.accounting.dao;

import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctCustom;

public interface AcctCustomMapper {
    int deleteByPrimaryKey(@Param("acctno") String acctno, @Param("accountBookId") String accountBookId);

    int insert(AcctCustom record);

    int insertSelective(AcctCustom record);

    AcctCustom selectByPrimaryKey(@Param("acctno") String acctno, @Param("accountBookId") String accountBookId);

    int updateByPrimaryKeySelective(AcctCustom record);

    int updateByPrimaryKey(AcctCustom record);
}