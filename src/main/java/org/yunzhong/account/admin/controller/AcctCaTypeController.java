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
import org.yunzhong.account.admin.model.AcctCaType;
import org.yunzhong.account.admin.service.AcctCaTypeService;
import org.yunzhong.account.admin.vo.CphRspMsg;
import org.yunzhong.account.admin.vo.RspHead;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

/**
 * @author yunzhong
 *
 */
@Controller
@RequestMapping("/manage/acct/acctcatype")
public class AcctCaTypeController {

    private static final Log log = LogFactory.getLog(OSBController.class);

    @Autowired
    private AcctCaTypeService caTypeService;

    @RequestMapping(value = "/{osbType}/list", method = RequestMethod.POST)
    public @ResponseBody CphRspMsg getAll(@PathVariable String osbType) {
        log.info("get acct ca types of osbtype {" + osbType + "}");
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            response.setBody(caTypeService.getAll(osbType));
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to get type list osbtype [" + osbType + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to get type list osbtype [" + osbType + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/{osbType}/{caTypeId}/delete", method = RequestMethod.POST)
    public @ResponseBody CphRspMsg delete(@PathVariable("osbType") String osbType,
            @PathVariable("caTypeId") String caTypeId) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            caTypeService.delete(osbType, caTypeId);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to delete acctType [" + osbType + caTypeId + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to delete acctType [" + osbType + caTypeId + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody CphRspMsg add(@RequestBody AcctCaType acctCaType) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            caTypeService.add(acctCaType);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add typeService [" + acctCaType.getCaTypeId() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add typeService [" + acctCaType.getCaTypeId() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody CphRspMsg update(@RequestBody AcctCaType acctCaType) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            caTypeService.update(acctCaType);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to update item [" + acctCaType.getOsbType() + acctCaType.getCaTypeId() + "]", e);
            response.getHead().setRetmsg(e.getMessage());
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to update item [" + acctCaType.getOsbType() + acctCaType.getCaTypeId() + "]", e);
            response.getHead().setRetmsg(e.getLocalizedMessage());
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
}
