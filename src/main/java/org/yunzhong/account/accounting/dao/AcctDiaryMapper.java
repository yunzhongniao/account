package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctDiary;

public interface AcctDiaryMapper {
    int deleteByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("acctno") String acctno, @Param("periodday") String periodday);

    int insert(AcctDiary record);

    AcctDiary selectByPrimaryKey(@Param("accountBookId") String accountBookId, @Param("acctno") String acctno, @Param("periodday") String periodday);

    List<AcctDiary> selectAll();

    int updateByPrimaryKey(AcctDiary record);
}