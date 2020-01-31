package org.yunzhong.account.accounting.model;

import lombok.Data;

@Data
public class AcctCreateLogicTemplate {

	private AcctItem item;
	
	private AcctTemplate template;
	
	private String accountNo;
}
