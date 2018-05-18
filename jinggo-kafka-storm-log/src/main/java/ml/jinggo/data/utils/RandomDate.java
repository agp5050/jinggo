package ml.jinggo.data.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期随即类
 */
public class RandomDate {
    public static void main(String[] args) {
        System.out.println(new RandomDate().run());
    }
    // 生成的日期
    private static final Date DATE = randomDate("2017-07-01", "2017-09-01");

    // 执行随机日期生成
    public static String run() {
        Date date = randomDate("2017-07-01", "2017-09-01");
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
    }

    /**
     * 获取随机日期
     *
     * @param beginDate 起始日期，格式为：yyyy-MM-dd
     * @param endDate   结束日期，格式为：yyyy-MM-dd
     * @return
     */
    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if (start.getTime() >= end.getTime()) {
                return null;
            }

            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // 随机
    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
}

