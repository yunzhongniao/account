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
import org.yunzhong.account.admin.model.OrgSalesBook;
import org.yunzhong.account.admin.service.OSBService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

import com.paytechsrv.cph.msg.CphRspMsg;
import com.paytechsrv.cph.msg.RspHead;

/**
 * @author yunzhong
 *
 */
@Controller
@RequestMapping("/manage/acct/osb")
public class OSBController {
    private static final Log log = LogFactory.getLog(OSBController.class);

    @Autowired
    private OSBService osbService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public CphRspMsg getAll() {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(osbService.getAll());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to get osb list", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to get osb list", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/{osbType}/delete", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg delete(@PathVariable("osbType") String osbType) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            osbService.delete(osbType);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete osbtype [" + osbType + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete osbtype [" + osbType + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg update(@RequestBody OrgSalesBook osb) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            osbService.update(osb);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to update osbtype [" + osb + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to update osbtype [" + osb + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody OrgSalesBook osb) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            osbService.add(osb);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add osbtype [" + osb + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add osbtype [" + osb + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

}
