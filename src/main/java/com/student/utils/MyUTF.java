package com.student.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

//解决中文乱码
public class MyUTF {


        //封装成工具类
        public static String getNewString(String str) throws UnsupportedEncodingException
        {
            return new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        }

}
