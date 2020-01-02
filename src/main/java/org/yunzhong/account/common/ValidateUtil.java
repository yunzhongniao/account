package org.yunzhong.account.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.yunzhong.account.admin.vo.ReqHead;

public class ValidateUtil {

    public static boolean validateN(String data, boolean needed, int minLen, int maxLen) {

        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        data = data.trim();
        if (data.length() < minLen || data.length() > maxLen)
            return false;
        String part = "-?[0-9]+";
        Pattern p = Pattern.compile(part);
        Matcher m = p.matcher(data);
        return m.matches();

    }

    public static boolean validateNValue(String data, boolean needed, long minValue, long maxValue) {

        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        data = data.trim();
        try {
            long value = Long.valueOf(data);
            if (value < minValue || value > maxValue)
                return false;
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public static boolean validateDec(String data, boolean needed, int numMax, int decMaxNum) {
        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        data = data.trim();
        int point = data.indexOf(".");
        if (point != -1) {

            if (point > decMaxNum)
                return false;
            if (data.substring(point, data.length()).length() > numMax + 1)
                return false;
        }
        Pattern pat = Pattern.compile("-?[0-9]*.?[0-9]*");
        Matcher mat = null;
        mat = pat.matcher(data);
        return mat.matches();
    }

    public static boolean validateVC(String data, boolean needed, int minLen, int maxLen) {
        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        if (data.length() < minLen || data.length() > maxLen)
            return false;
        return true;
    }

    public static boolean validateVC(byte[] data, boolean needed, int minLen, int maxLen) {
        if (data == null || data.length == 0) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        if (data.length < minLen || data.length > maxLen)
            return false;

        return true;
    }

    public static boolean validateVC(String data, boolean needed, int minLen) {

        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        if (data.length() < minLen)
            return false;
        return true;
    }

    public static boolean validateDateTime(String data, boolean needed, String pattern) {
        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        DateFormat df = new SimpleDateFormat(pattern);
        Date dateTime;
        try {
            dateTime = df.parse(data.trim());
        } catch (Exception e) {
            dateTime = null;
        }
        if (dateTime == null)
            return false;

        return true;
    }

    public static boolean validateStaticData(String data, boolean needed, String... patterns) {
        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        for (String pa : patterns) {
            if (data.equals(pa))
                return true;
        }
        return false;
    }

    public static boolean validList(List list, boolean needed) {
        if (needed) {
            return null != list && list.size() > 0;
        }
        return true;
    }

    public static boolean validateVCByBytes(String data, boolean needed, int minLen, int maxLen) {
        if (isEmpty(data)) {
            if (needed) {
                return false;
            } else {
                return true;
            }
        }
        byte[] tt = data.getBytes();
        if (tt.length < minLen || tt.length > maxLen)
            return false;

        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    public static boolean validateBodyFromHead(ReqHead reqhead, String osbidinbody) throws Exception {
        if (!osbidinbody.equals(reqhead.getUserosbid()))
            throw new Exception("报文体中机构号当前要求与报文头中相同");
        return true;
    }
}
