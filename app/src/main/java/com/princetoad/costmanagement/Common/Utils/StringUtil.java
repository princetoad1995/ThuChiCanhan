package com.princetoad.costmanagement.Common.Utils;

import android.util.Base64;

/**
 * Created by PRINCE D. TOAD on 3/25/2017.
 */

public class StringUtil {
    public static boolean isBlank(String str) {
        if (str == null || str.equals("")) {
            return true;
        }
        return false;
    }

    public static String formatLocaleVN(long str) {
        int i = 3;
        String s = reverseString(String.valueOf(str));
        StringBuilder format = new StringBuilder(s);
        while (i < format.length()) {
            s = format.insert(i, ".").toString();
            i = i + 4;
        }
        return reverseString(s);
    }

    public static String reverseString(String str) {
        String s = new StringBuffer(String.valueOf(str)).reverse().toString();
        return s;
    }

}

