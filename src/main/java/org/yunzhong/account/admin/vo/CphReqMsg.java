package org.yunzhong.account.admin.vo;

public class CphReqMsg<T> {

    private ReqHead head;
    private T body;

    public CphReqMsg() {
    }

    public ReqHead getHead() {
        return head;
    }

    public void setHead(ReqHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
