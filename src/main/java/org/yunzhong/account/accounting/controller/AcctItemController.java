package org.yunzhong.account.accounting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctBasicRequestBody;
import org.yunzhong.account.accounting.api.AcctRequest;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.service.AcctItemService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("item")
public class AcctItemController {

	@Autowired
	private AcctItemService itemService;

	@ApiOperation(value = "分录规则", notes = "账簿查询分录规则", httpMethod = "POST")
	@ApiImplicitParam(dataType = "AcctRequest«AcctBasicRequestBody»", name = "request", value = "requestbody", required = true)
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public AcctResponse selectAll(@RequestBody AcctRequest<AcctBasicRequestBody> request) {
		return AcctResponseBuilder.create(itemService.selectByAccountBook(request.getBody().getAccountBookId()));
	}
}
