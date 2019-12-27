package org.yunzhong.account.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yunzhong.account.admin.model.TrxBook;
import org.yunzhong.account.admin.service.TrxBookService;
import org.yunzhong.account.common.ServiceException;
import org.yunzhong.account.common.dict.CphErrorCode;

import com.paytechsrv.cph.acctservice.front.TPFrontService;
import com.paytechsrv.cph.msg.CphRspMsg;
import com.paytechsrv.cph.msg.RspHead;
import com.paytechsrv.cph.msg.front.ca.TPHead;
import com.paytechsrv.cph.msg.front.ca.TPInfo;
import com.paytechsrv.cph.msg.front.ca.TPRecord;
import com.paytechsrv.cph.msg.front.ca.body.TPPostTrxReq;

@Controller
@RequestMapping("/manage/acct/trxbook")
public class TrxBookController {

    private static final Log log = LogFactory.getLog(TrxBookController.class);

    @Autowired
    private TrxBookService trxBookService;
    @Autowired
    private TPFrontService tpsvc;

    @InitBinder
    public void intDate(WebDataBinder dataBinder){
        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"),"transDate","accountDate");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CphRspMsg add(@RequestBody TrxBook trxBook) {
        CphRspMsg response = new CphRspMsg();
        response.setHead(new RspHead());
        try {
            trxBookService.add(trxBook);

            TPHead tpHead = new TPHead();
            tpHead.setTptype(1);
            tpHead.setOsbid(trxBook.getOsbId());
            tpHead.setTrxdir(trxBook.getTrxDir());
            tpHead.setPid(trxBook.getOsbId());
            tpHead.setTrxcode(trxBook.getTrxCode());
            tpHead.setTrxid(trxBook.getTrxId());
            tpHead.setCurrtype(trxBook.getCurrency());
            tpHead.setActionx("end");

            List<TPRecord> records = new ArrayList<>();
            TPRecord record = new TPRecord();
            record.setTrxamt(trxBook.getPaymentAmount().longValue());
            records.add(record);

            TPInfo tpInfo = new TPInfo();
            tpInfo.setHead(tpHead);
            tpInfo.setRecords(records);

            TPPostTrxReq trxReq = new TPPostTrxReq();
            trxReq.setTpinfo(tpInfo);

            tpsvc.postTrx(trxReq);

            response.getHead().setRetcode(CphErrorCode.ERR_CODE_SUCCESS);
        } catch (ServiceException e) {
            log.error("Failed to add trxCat [" + trxBook.getTrxId() + "]", e);
            response.getHead().setRetcode(e.getStatus());
        } catch (Exception e) {
            log.error("Failed to add trxCat [" + trxBook.getTrxId() + "]", e);
            response.getHead().setRetcode(CphErrorCode.ERR_CODE_EXCEPTION);
        }
        return response;
    }
}
