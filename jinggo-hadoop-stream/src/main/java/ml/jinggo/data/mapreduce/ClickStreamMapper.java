package ml.jinggo.data.mapreduce;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ml.jinggo.data.logentry.AccessLogBean;
import ml.jinggo.data.utils.CodeFormatter;
import ml.jinggo.data.utils.IpParser;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * ClassName: ClickStreamMapper
 * @Description: MR的Mapper类，负责对apache日志进行解析
 * @author 王宏
 * @date 2017年11月20日
 */
public class ClickStreamMapper extends Mapper<LongWritable, Text, Text, Text> {

	/**
	 * @Fields APACHE_LOG_REGEX : 识别Apache access_log的日正则
	 */
	public static final String APACHE_LOG_REGEX = "^([\\d.]+|-) (\\S+|-) (\\S+|-) \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"(.+?)\" (\\d{3}|-) (\\d+|-) \"([^\"]+)\" \"([^\"]+)\"";
	/**
	 * @Fields NUM_FIELDS : 正常的access_log日志的fields为9。
	 */
	public static final int NUM_FIELDS = 9;
	/**
	 * @Fields SPLIT_CHAR : 字符拆分格式
	 */
	public static final String SPLIT_CHAR = "\t";


	/* (non-Javadoc)
	 * @see org.apache.hadoop.mapreduce.Mapper#map(KEYIN, VALUEIN, org.apache.hadoop.mapreduce.Mapper.Context)
	 */
	protected void map(LongWritable key, Text value, Context context)
			throws java.io.IOException, InterruptedException {
		// 初始化声明变量。
		AccessLogBean logBean = new AccessLogBean("nothing");
		// 默认会带domain前缀,在这里将他替换掉。
		String logEntryLine = CodeFormatter.transformTextToUTF8(value, "UTF-8").toString()
				.replace("bbs.moonseo.cn ", "");
		// 正则匹配
		Pattern pattern = Pattern.compile(APACHE_LOG_REGEX);
		Matcher matcher = pattern.matcher(logEntryLine);

		if (!matcher.matches() || NUM_FIELDS != matcher.groupCount()) {
			System.err.println("正则解析日志失败。");
			System.err.println(logEntryLine);
			return;
		}
		// 通过正则，来解析数据
		logBean.setIpAddress(matcher.group(1));
		logBean.setDateTime(matcher.group(4));
		logBean.setRequests(matcher.group(5));
		logBean.setResponseStats(matcher.group(6));
		logBean.setBytesSent(matcher.group(7));
		if (!matcher.group(8).equals("-"))
			logBean.setReferer(matcher.group(8));
		logBean.setBrowser(matcher.group(9));

		IpParser ipParser = new IpParser();

		try {
			// 用qqwry获得对方ip对应地址和本地Ip对应地址
			String address = logBean.getIpAddress();
			logBean.setAreaAddress(ipParser.parse(address).split(" ")[0]);
			logBean.setLoaclAddress(ipParser.parse(address).split(" ")[1]);

		} catch (Exception e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z",
				Locale.US);
		try {
			Date date = df.parse(logBean.getDateTime());
			// 获得指定时间
			logBean.setReceiveTime(Long.toString(date.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// key格式化输出
		String mapOutKey = logBean.getReceiveTime();
		// value格式化输出
		String mapOutValue = logBean.combineString(SPLIT_CHAR);
		context.write(new Text(mapOutKey), new Text(mapOutValue));
	};
}
