package org.yunzhong.account.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctBasicRequestBody;
import org.yunzhong.account.accounting.api.AcctRequest;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.service.AcctCurrencyTypeService;

@RestController
@RequestMapping("currency/type")
public class AcctCurrencyTypeController {

	@Autowired
	private AcctCurrencyTypeService acctCurrencyTypeService;

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@PreAuthorize("hasPermission('/list','currency:read')")
	public AcctResponse selectAll(@RequestBody AcctRequest<AcctBasicRequestBody> request) {
		return AcctResponseBuilder.create(acctCurrencyTypeService.selectAll());
	}
}
