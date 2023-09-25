package com.nosuchfield.jinx;

public class Utils {

    /**
     * 移除第一个和最后一个字符
     *
     * @param data 原始字符串
     * @return 处理后的字符串
     */
    public static String removeFirstAndLastChar(String data) {
        if (data.length() < 2) {
            return data;
        }
        return data.substring(1, data.length() - 1);
    }

}
