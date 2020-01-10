package org.yunzhong.account.accounting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunzhong.account.accounting.api.AcctResponse;
import org.yunzhong.account.accounting.api.AcctResponseBuilder;
import org.yunzhong.account.accounting.model.AcctTransactionCat;
import org.yunzhong.account.accounting.service.AcctTransactionCatService;

@RestController
@RequestMapping("transaction/category")
public class AcctTransactionCatController {

    @Autowired
    private AcctTransactionCatService transactionCatService;

    @RequestMapping("/list/abtype/{abtype}")
    public AcctResponse listByAccountBookType(@PathVariable("abtype") String abType) {
        List<AcctTransactionCat> cats = transactionCatService.listByAccountBookType(abType);
        return AcctResponseBuilder.create(cats);
    }
}
