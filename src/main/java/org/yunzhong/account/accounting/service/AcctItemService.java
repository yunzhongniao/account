package org.yunzhong.account.accounting.service;

import java.util.List;

import org.yunzhong.account.accounting.model.AcctItem;

public interface AcctItemService {

	List<AcctItem> selectByAccountBook(String accountBookId);

}
