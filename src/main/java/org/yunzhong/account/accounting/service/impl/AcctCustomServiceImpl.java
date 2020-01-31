package org.yunzhong.account.accounting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunzhong.account.accounting.api.AcctCustomCreateRequest;
import org.yunzhong.account.accounting.dao.AcctCustomMapper;
import org.yunzhong.account.accounting.service.AcctCustomService;

@Service
public class AcctCustomServiceImpl implements AcctCustomService {

	@Autowired
	private AcctCustomMapper customMapper;

	@Override
	public void createCustom(AcctCustomCreateRequest request) {
		// TODO Auto-generated method stub
		
	}
}
