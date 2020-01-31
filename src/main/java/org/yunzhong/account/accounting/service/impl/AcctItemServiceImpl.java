package org.yunzhong.account.accounting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.AcctAccountBookMapper;
import org.yunzhong.account.accounting.dao.AcctItemMapper;
import org.yunzhong.account.accounting.model.AcctAccountBook;
import org.yunzhong.account.accounting.model.AcctItem;
import org.yunzhong.account.accounting.service.AcctItemService;
import org.yunzhong.account.common.ServiceException;

@Service
public class AcctItemServiceImpl implements AcctItemService {

	@Autowired
	private AcctItemMapper itemMapper;
	
	@Autowired
	private AcctAccountBookMapper accountBookMapper;
	
	@Override
	public List<AcctItem> selectByAccountBook(String accountBookId) {
		 AcctAccountBook accountBook = accountBookMapper.selectByPrimaryKey(accountBookId);
	        if (accountBook == null) {
	            throw new ServiceException("账簿不存在");
	        }
	        return itemMapper.selectByAccountBookType(accountBook.getAccountBookType());
	}

}
