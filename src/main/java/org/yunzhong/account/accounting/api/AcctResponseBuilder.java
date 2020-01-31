package org.yunzhong.account.accounting.api;

public class AcctResponseBuilder {

	private static final String INNER_ERROR_CODE = "500";

	public static AcctResponse create(Object result) {
		return new AcctResponse(result);
	}

	public static AcctResponse create(String code, String message, Object result) {
		return new AcctResponse(code, message, result);
	}

	public static AcctResponse createError(String message) {
		return new AcctResponse(INNER_ERROR_CODE, message, null);
	}
}
