package org.yunzhong.account.admin.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yunzhong.account.admin.model.TrxCat;
import org.yunzhong.account.admin.service.TrxCatService;
import org.yunzhong.account.admin.vo.CphRspMsg;
import org.yunzhong.account.admin.vo.RspHead;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

@Controller
@RequestMapping("/manage/acct/trxcat")
public class TrxCatController {

    private static final Log log = LogFactory.getLog(TrxCatController.class);

    @Autowired
    private TrxCatService trxService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CphRspMsg getAll() {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(trxService.getAll());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to get trx list .", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to get trx list", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/{trxCode}/delete", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg delete(@PathVariable("trxCode") String trxCode) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            trxService.delete(trxCode);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete trxcat [" + trxCode + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete trxcat [" + trxCode + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg update(@RequestBody TrxCat trxCat) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            trxService.update(trxCat);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to update trxCat [" + trxCat.getTrxCode() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to update trxCat [" + trxCat.getTrxCode()+ "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody TrxCat trxCat) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            trxService.add(trxCat);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add trxCat [" + trxCat.getTrxCode() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add trxCat [" + trxCat.getTrxCode() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
}
