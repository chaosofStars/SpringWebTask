package com.netease.course.utils;

import java.io.UnsupportedEncodingException;

public class TransformUtil {
    public static String toString(byte[] blob) throws UnsupportedEncodingException {
        return new String(blob,"UTF-8");
    }

    public static byte[] toByte(String blob) throws UnsupportedEncodingException {
        return blob.getBytes("UTF-8");
    }

}
