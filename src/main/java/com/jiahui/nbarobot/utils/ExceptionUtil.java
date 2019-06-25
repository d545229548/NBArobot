package com.jiahui.nbarobot.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常处理工具类
 * @author dongjiahui
 */
public class ExceptionUtil {


    /**
     * 获取异常的具体堆栈信息
     * @param t 异常对象
     * @return 具体信息
     */
    public static String getTrace(Throwable t) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer = stringWriter.getBuffer();
        return buffer.toString();
    }
}

