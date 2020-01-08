package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctCustom;

public interface AcctCustomMapper {
    int deleteByPrimaryKey(@Param("acctno") String acctno, @Param("accountBookId") String accountBookId);

    int insert(AcctCustom record);

    AcctCustom selectByPrimaryKey(@Param("acctno") String acctno, @Param("accountBookId") String accountBookId);

    List<AcctCustom> selectAll();

    int updateByPrimaryKey(AcctCustom record);
}