package org.yunzhong.account.accounting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctCustomCreateRequest;
import org.yunzhong.account.accounting.api.AcctRequest;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.service.AcctCustomService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("custom")
public class AcctCustomController {
	private static final Logger log = LoggerFactory.getLogger(AcctCustomController.class);

	@Autowired
	private AcctCustomService customService;

	@ApiOperation(value = "创建账户", notes = "创建账户", httpMethod = "POST")
	@ApiImplicitParam(dataType = "AcctRequest«AcctBasicRequestBody»", name = "request", value = "requestbody", required = true)
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public AcctResponse createCustom(@RequestBody AcctRequest<AcctCustomCreateRequest> request) {
		try {
			customService.createCustom(request.getBody());
		} catch (Exception e) {
			log.error("create custom error", e);
			return AcctResponseBuilder.createError("创建账户失败：" + e.getLocalizedMessage());
		}
		return AcctResponseBuilder.create(null);
	}
}
