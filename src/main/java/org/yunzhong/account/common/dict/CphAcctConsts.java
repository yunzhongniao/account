package org.yunzhong.account.common.dict;

public class CphAcctConsts {
	public static final int DEBIT = 1;
	public static final int CREDIT = 2;

	public static final int BALBY_DR = 1;
	public static final int BALBY_CR = 2;
	public static final int BALBY_CRDR = 3;
	public static final int BALBY_CRDRNET = 4;
	
	public static final int ITEMCLASS_ASSETS = 1;
	public static final int ITEMCLASS_LIBILITY = 2;
	public static final int ITEMCLASS_ASLBCOMMON = 3;
	public static final int ITEMCLASS_OWNERSEQUITY = 4;
	public static final int ITEMCLASS_COST = 5;
	public static final int ITEMCLASS_GAINLOSS = 6;
	
	public final static int ENTRY_POSTFLAG = 1;
	public final static int ENTRY_UNPOSTFLAG = 0;
	public final static int ENTRY_GENLEDFLAG = 1;
	public final static int ENTRY_UNGENLEDFLAG = 0;
	
	public final static String ORGTYPE_INNER = "0";
	public final static String ORGTYPE_BANK = "1";
	public final static String ORGTYPE_CHNL = "2";
	
	public final static String ACCTNATURE_ACCT = "00";
	public final static String ACCTNATURE_CA = "10";
	public final static String ACCTNATURE_INNER = "99";
	
	public final static String VOUCHERTYPE_TRX = "1";
	
	public final static int TRXCAT_PAY = 1;
	public final static int TRXCAT_RECHARGE = 2;
	public final static int TRXCAT_DEPOSIT = 3;
	public final static int TRXCAT_TRANSFER = 4;
	
	public final static int EVENTX_CHECK = 1;
	public final static int EVENTX_POST = 2;
	
	public final static String ACTIONX_START = "start";
	public final static String ACTIONX_END = "end";
	
	public final static int TPTYPE_TRXNML = 1;
	public final static int TPTYPE_TRXREV = 2;
	
	public final static int REVTYPE_RED = 1;
	public final static int REVTYPE_CRDR = 2;
	
	public static final String TRXDIRS = "101003";
	public static final String TRXDIRF = "101104";
	
	public static final String ACCTSTATE_NORMAl = "01";
	public static final String ACCTSTATE_NEEDACTIVATE = "02";
	public static final String ACCTSTATE_FROZEN_IN = "11";
	public static final String ACCTSTATE_FROZEN_OUT = "12";
	public static final String ACCTSTATE_FROZEN = "13";
	public static final String ACCTSTATE_WAIT_DESTRUCT = "91";
	public static final String ACCTSTATE_DESTRUCTED = "99";
	
	public static final int ENTRYTYPE_NORMAL = 1;
	public static final int ENTRYTYPE_REV = 9;
	
	public static final String ACCTOSBSTATE_WAITSETUP = "0";
	public static final String ACCTOSBSTATE_NORMAL = "1";
	public static final String ACCTOSBSTATE_SHUTDOWN = "2";
	
	public static final String CUSLIMIT_STATE_NORMAL  = "1";
	public static final String CUSLIMIT_STATE_UNVALID = "2";
	public static final String CUSLIMIT_STATE_DEL 	  = "9";
	
	public static final String CALIMIT_STATE_NORMAL  = "1";
	public static final String CALIMIT_STATE_UNVALID = "2";
	public static final String CALIMIT_STATE_DEL 	 = "9";	
	
	public static final int CURRLOCAL_NO = 0;
	
	public static final int AUPERM_TYPE_INTERFACE = 1;
}
