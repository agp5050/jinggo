package ml.jinggo.data.utils;

import java.util.Random;
/**
 * 用户名随机
 * 用来模拟随机生成用户名
 */
public class RandomUserName {
    // 初始化常量a...z
    private static final char[] eng_char = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // 初始化常量中文姓名拼音
    private static final String[] first_name = new String[]{"zhao", "qian", "sun", "li", "zhou", "wang", "wu", "zheng", "feng", "chen", "chu", "wei", "jiang", "shen", "yang"
            , "zhu", "qin", "you", "xu", "he", "shi", "zhan", "kong", "cao", "xie", "jin", "shu", "fang", "yuan"};
    // 初始化常量13 18 15
    private static final String[] tel_head = new String[]{"13", "18", "15"};
    // 初始化常量邮箱后缀邮箱后缀
    private static final String[] email_suffix = new String[]{"@gmail.com", "@yahoo.com", "@msn.com", "@hotmail.com", "@aol.com", "@ask.com"
            , "@live.com", "@qq.com", "@0355.net", "@163.com", "@163.net", "@263.net"
            , "@3721.net", "@yeah.net", "@googlemail.com", "@126.com", "@sina.com", "@sohu.com", "@yahoo.com.cn"};
    // 声明变量
    private static Random random = new Random();

    public static void main(String[] args) {
        RandomUserName ran = new RandomUserName();
        for (int i = 0; i < 200; i++) {
            System.out.println(ran.run());
        }
    }
    // 执行生成方法
    public static String run() {
        StringBuilder uName = new StringBuilder();
        // 通过随机来进行抓阄，然后模运算去选取生成什么用户名。
        int randomType = random.nextInt(Integer.MAX_VALUE) % 3;
        switch (randomType) {
            case 0: // firstName + randomSecName + birthday
                uName.append(first_name[random.nextInt(Integer.MAX_VALUE) % first_name.length])
                        .append(eng_char[random.nextInt(Integer.MAX_VALUE) % eng_char.length]);

                if (random.nextInt(Integer.MAX_VALUE) % 2 == 0) {
                    uName.append(eng_char[random.nextInt(Integer.MAX_VALUE) % eng_char.length]);
                }

                // birthday
                if (random.nextInt(Integer.MAX_VALUE) % 2 == 0) {
                    uName.append(String.valueOf(2014 - (random.nextInt(Integer.MAX_VALUE) % (50 - 15) + 15))); // 大于15小于50岁
                }
                if (random.nextInt(Integer.MAX_VALUE) % 2 == 0) {
                    int month = random.nextInt(Integer.MAX_VALUE) % 11 + 1;
                    int day = random.nextInt(Integer.MAX_VALUE) % 29 + 1;
                    if (month < 10)
                        uName.append("0");
                    uName.append(month);
                    if (day < 10)
                        uName.append("0");
                    uName.append(day);
                }
                if (random.nextInt(Integer.MAX_VALUE % 4) == 0) {// add email suffix , 1/4 rate
                    uName.append(email_suffix[random.nextInt(Integer.MAX_VALUE) % email_suffix.length]);
                }
                break;
            case 1: // tel
                uName.append(tel_head[random.nextInt(Integer.MAX_VALUE) % tel_head.length])
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10);
                break;
            case 2: // qq
                uName.append(random.nextInt(Integer.MAX_VALUE) % 9 + 1)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10)
                        .append(random.nextInt(Integer.MAX_VALUE) % 10);
                int lenth = 0;
                while (random.nextInt(Integer.MAX_VALUE) % 2 == 0) {
                    if (lenth > 6)
                        break;
                    uName.append(random.nextInt(Integer.MAX_VALUE) % 10);
                    lenth++;
                }
                break;

            default:
                break;
        }
        return uName.toString();
    }
}