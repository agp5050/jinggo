import ml.jinggo.data.logentry.AccessLogBean;
import ml.jinggo.data.utils.CodeFormatter;
import org.apache.hadoop.io.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangyj
 * @description
 * @create 2018-05-18 11:47
 **/
public class LogRegexTest {

    public static final String APACHE_LOG_REGEX = "^([\\d.]+|-) (\\S+|-) (\\S+|-) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}|-) (\\d+|-) \"([^\"]+)\" \"([^\"]+)\"";

    public static void main(String[] args) {
        String value = "218.19.140.242 – – [10/Dec/2010:09:31:17 +0800]";
        Text text  = new Text(value);
        // 初始化声明变量。
        AccessLogBean logBean = new AccessLogBean("nothing");
        // 默认会带domain前缀,在这里将他替换掉。
        String logEntryLine = CodeFormatter.transformTextToUTF8(text, "UTF-8").toString()
                .replace("bbs.moonseo.cn ", "");
        System.out.println("LogRegexTest.main====>>> " + logEntryLine);

        // 正则匹配
        Pattern pattern = Pattern.compile(APACHE_LOG_REGEX);
        Matcher matcher = pattern.matcher(logEntryLine);

        // 通过正则，来解析数据
        logBean.setIpAddress(matcher.group(1));
        logBean.setDateTime(matcher.group(4));
        logBean.setRequests(matcher.group(5));
        logBean.setResponseStats(matcher.group(6));
        logBean.setBytesSent(matcher.group(7));
        if (!matcher.group(8).equals("-"))
            logBean.setReferer(matcher.group(8));
        logBean.setBrowser(matcher.group(9));

        System.out.println("LogRegexTest.main2====>>> " + logBean.toString());
    }
}
