package com.nosuchfield.jinx;

public class Utils {

    public static String removeFirstAndLastChar(String data) {
        if (data.length() < 2) {
            return data;
        }
        return data.substring(1, data.length() - 1);
    }

}
