package ml.jinggo.data.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 店铺id随机生成类
 */
public class ShopIDBuilder {

    public static void main(String args[]) {
        System.out.println(run());
    }

    public static String run() {
        String Orderno = null;
        String maxOrderno = "NO201701270001"; // 从数据库查询出的最大编号
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); // 时间字符串产生方式
        String uid_pfix = "NO" + format.format(new Date()); // 组合流水号前一部分，NO+时间字符串，如：NO20170126
        if (maxOrderno != null && maxOrderno.contains(uid_pfix)) {
            String uid_end = maxOrderno.substring(10, 14); // 截取字符串最后四位，结果:0001
            int endNum = Integer.parseInt(uid_end); // 把String类型的0001转化为int类型的1
            int tmpNum = 10000 + endNum + 1; // 结果10002
            System.out.println("tmpNum=" + tmpNum);
            Orderno = uid_pfix + Tools.subStr("" + tmpNum, 1);// 把10002首位的1去掉，再拼成NO201701260002字符串
        } else {
            Orderno = uid_pfix + new Random().nextInt(10000);
        }
        return Orderno;
    }
}

class Tools {
    public static String subStr(String str, int start) {
        if (str == null || str.equals("") || str.length() == 0)
            return "";
        if (start < str.length()) {
            return str.substring(start);
        } else {
            return "";
        }
    }
}
