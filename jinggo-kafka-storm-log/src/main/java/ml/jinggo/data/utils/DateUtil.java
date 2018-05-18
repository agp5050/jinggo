package ml.jinggo.data.utils;

import java.util.Date;

/**
 * 日志工具类
 */
public class DateUtil {
    // 将日志转换成long类型
    public static long timeToLong(){
        return new Date().getTime();
    }
}
