package org.yunzhong.account.accounting.service;

import org.yunzhong.account.accounting.api.AcctCustomCreateRequest;

public interface AcctCustomService {

	void createCustom(String user, AcctCustomCreateRequest request);

}
