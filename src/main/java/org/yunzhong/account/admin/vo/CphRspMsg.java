package org.yunzhong.account.admin.vo;

public class CphRspMsg {

    private RspHead head;
    private Object body;

    public CphRspMsg() {
    }

    public RspHead getHead() {
        return head;
    }

    public void setHead(RspHead head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
