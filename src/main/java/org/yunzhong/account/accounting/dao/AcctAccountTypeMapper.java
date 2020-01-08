package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctAccountType;

public interface AcctAccountTypeMapper {
    int deleteByPrimaryKey(@Param("accountBookType") String accountBookType, @Param("accttype") String accttype);

    int insert(AcctAccountType record);

    AcctAccountType selectByPrimaryKey(@Param("accountBookType") String accountBookType, @Param("accttype") String accttype);

    List<AcctAccountType> selectAll();

    int updateByPrimaryKey(AcctAccountType record);
}