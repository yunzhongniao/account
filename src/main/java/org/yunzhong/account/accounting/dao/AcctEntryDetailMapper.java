package org.yunzhong.account.accounting.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.yunzhong.account.accounting.model.AcctEntryDetail;

public interface AcctEntryDetailMapper {
    int deleteByPrimaryKey(@Param("voucherno") String voucherno, @Param("entryno") Long entryno, @Param("accountBookId") String accountBookId, @Param("entrypty") Long entrypty);

    int insert(AcctEntryDetail record);

    AcctEntryDetail selectByPrimaryKey(@Param("voucherno") String voucherno, @Param("entryno") Long entryno, @Param("accountBookId") String accountBookId, @Param("entrypty") Long entrypty);

    List<AcctEntryDetail> selectAll();

    int updateByPrimaryKey(AcctEntryDetail record);
}