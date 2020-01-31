package org.yunzhong.account.accounting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.dao.AcctAccountBookMapper;
import org.yunzhong.account.accounting.dao.AcctCaTypeMapper;
import org.yunzhong.account.accounting.model.AcctAccountBook;
import org.yunzhong.account.accounting.model.AcctCaType;
import org.yunzhong.account.accounting.service.AcctCaTypeService;
import org.yunzhong.account.common.ServiceException;

@Service
public class AcctCaTypeServiceImpl implements AcctCaTypeService {

	@Autowired
	private AcctCaTypeMapper caTypeMapper;
	
	@Autowired
	private AcctAccountBookMapper accountBookMapper;

	@Override
	public List<AcctCaType> selectByAccountBook(String accountBookId) {
		AcctAccountBook accountBook = accountBookMapper.selectByPrimaryKey(accountBookId);
	        if (accountBook == null) {
	            throw new ServiceException("账簿不存在");
	        }
	        return caTypeMapper.selectByAccountBookType(accountBook.getAccountBookType());
	}
}
