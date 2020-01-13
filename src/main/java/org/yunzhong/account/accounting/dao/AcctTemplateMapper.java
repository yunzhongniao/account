package org.yunzhong.account.accounting.dao;

import org.yunzhong.account.accounting.model.AcctTemplate;

public interface AcctTemplateMapper {
    int deleteByPrimaryKey(Long tplid);

    int insert(AcctTemplate record);

    int insertSelective(AcctTemplate record);

    AcctTemplate selectByPrimaryKey(Long tplid);

    int updateByPrimaryKeySelective(AcctTemplate record);

    int updateByPrimaryKey(AcctTemplate record);
}