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
import org.yunzhong.account.accounting.service.AcctTransactionCatService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 交易类型
 * 
 * @author yunzhong
 * @date 2020年1月22日
 */
@RestController
@RequestMapping("transaction/category")
public class AcctTransactionCatController {

    @Autowired
    private AcctTransactionCatService transactionCatService;

    @ApiOperation(value = "ab查询交易类型", notes = "交易类型查询", httpMethod = "POST")
    @ApiImplicitParam(dataType = "AcctRequest«AcctBasicRequestBody»", name = "request", value = "requestbody", required = true)
    @RequestMapping(value = "/accountbook/list", method = RequestMethod.POST)
    public AcctResponse getByAbType(@RequestBody AcctRequest<AcctBasicRequestBody> request) {
        return AcctResponseBuilder
                .create(transactionCatService.listByAccountBook(request.getBody().getAccountBookId()));
    }
}
