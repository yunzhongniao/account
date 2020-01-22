package org.yunzhong.account.accounting.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctBasicRequestBody;
import org.yunzhong.account.accounting.api.AcctRequest;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.service.AcctAccountTypeService;
import org.yunzhong.account.common.ServiceException;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("account/type")
public class AcctAccountTypeController {

    @Autowired
    private AcctAccountTypeService acctAccountTypeService;

    @ApiOperation(value = "账户类型", notes = "查询账户类型", httpMethod = "POST")
    @ApiImplicitParam(dataType = "AcctRequest«AcctBasicRequestBody»", name = "request", value = "requestbody", required = true)
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public AcctResponse selectAll(@RequestBody AcctRequest<AcctBasicRequestBody> request) {
        Optional.ofNullable(request.getBody()).orElseThrow(ServiceException::create);
        return AcctResponseBuilder
                .create(acctAccountTypeService.selectByAccountBook(request.getBody().getAccountBookId()));
    }
}
