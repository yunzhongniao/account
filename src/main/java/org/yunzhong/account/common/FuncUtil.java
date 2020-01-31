package org.yunzhong.account.common;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public class FuncUtil {

	public static String dropNull(String input) {
		if (input == null) {
			input = "";
		}
		return input.trim();
	}

	public static String formatTime(Date date, String formatter) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(date);
	}

	public static String formatTime(Timestamp date, String formatter) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		Date date_new = new Date(date.getTime());
		return sdf.format(date_new);
	}

	public static boolean isNum(String str) {
		boolean flag = false;
		Pattern pat = Pattern.compile("^[0-9]*$");
		Matcher mat = null;
		mat = pat.matcher(str);
		flag = mat.matches();
		return flag;
	}

	public static boolean isNumber(String str) {
		if (StringUtils.isEmpty(str))
			return false;
		boolean flag = false;
		Pattern pat = Pattern.compile("-?[0-9]*.?[0-9]*");
		Matcher mat = null;
		mat = pat.matcher(str);
		flag = mat.matches();
		return flag;
	}

	public static BigDecimal ftoy(BigDecimal num) {
		return num.divide(new BigDecimal(100), 2, BigDecimal.ROUND_CEILING);
	}

	public static BigDecimal ftoy(long num) {
		return ftoy(new BigDecimal(num));
	}

	public static BigDecimal ftoy(String num) {
		return ftoy(new BigDecimal(num));
	}

	public static BigDecimal ytof(String y) {
		return new BigDecimal(Math.round(new BigDecimal(y).multiply(new BigDecimal(100)).doubleValue()));
	}

	public static BigDecimal ytof(double y) {
		return ytof(String.valueOf(y));
	}

	public static BigDecimal ytof(BigDecimal y) {
		return ytof(y.toString());
	}

	public static SortedMap<String, String> mapSortByKey(Map<String, String> unsort_map) {
		TreeMap<String, String> result = new TreeMap<String, String>();
		Object[] unsort_key = unsort_map.keySet().toArray();
		Arrays.sort(unsort_key);
		for (int i = 0; i < unsort_key.length; i++) {
			result.put(unsort_key[i].toString(), unsort_map.get(unsort_key[i]));
		}
		return result.tailMap(result.firstKey());
	}

}
