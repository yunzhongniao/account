package org.yunzhong.account.accounting.dao;

import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctDiary;

public interface AcctDiaryMapper {
    int deleteByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("acctno") String acctno, @Param("periodday") String periodday);

    int insert(AcctDiary record);

    int insertSelective(AcctDiary record);

    AcctDiary selectByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("acctno") String acctno, @Param("periodday") String periodday);

    int updateByPrimaryKeySelective(AcctDiary record);

    int updateByPrimaryKey(AcctDiary record);
}