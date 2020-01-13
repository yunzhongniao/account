package org.yunzhong.account.accounting.dao;

import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctEntryDetail;

public interface AcctEntryDetailMapper {
    int deleteByPrimaryKey(@Param("voucherno") String voucherno, @Param("entryno") Long entryno, @Param("accountBookId") String accountBookId, @Param("entrypty") Long entrypty);

    int insert(AcctEntryDetail record);

    int insertSelective(AcctEntryDetail record);

    AcctEntryDetail selectByPrimaryKey(@Param("voucherno") String voucherno, @Param("entryno") Long entryno, @Param("accountBookId") String accountBookId, @Param("entrypty") Long entrypty);

    int updateByPrimaryKeySelective(AcctEntryDetail record);

    int updateByPrimaryKey(AcctEntryDetail record);
}