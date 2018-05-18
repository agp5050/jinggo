package ml.jinggo.data.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * OrderId建造类
 * 用于实例化建造OrderId
 */
public class OrderIdBuilder {
    // order起始数量
    private static long orderNum = 0l;
    // 日期
    private static String date;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            System.out.println(OrderIdBuilder.run());
        }
    }
    // 单线程执行，保证唯一性
    public static synchronized String run() {
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if (date == null || !date.equals(str)) {
            date = str;
            orderNum = 0l;
        }
        orderNum++;
        long orderNo = Long.parseLong((date)) * 10000;
        orderNo += orderNum;
        return orderNo + "";
    }
}
