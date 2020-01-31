package org.yunzhong.account.accounting.service;

import java.util.List;

import org.yunzhong.account.accounting.model.AcctCaType;

public interface AcctCaTypeService {

	List<AcctCaType> selectByAccountBook(String accountBookId);

}
