package org.yunzhong.account.accounting.model;

import lombok.Data;

@Data
public class AcctTransactionCat {
    private String trxcode;

    private Byte trxcat;

    private String trxname;

    private String showinpage;

    private String showinmer;

    private String trxdir;

    private String priority;

    private String nameforacct;

    private String merentry;

    private Byte iscalucost;

    private String isreal;

    private String issett;

    private String resend;

    private String issyscmn;

    private Byte isrev;
    
    private String abtype;

}