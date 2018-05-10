package ml.jinggo.data.utils;

import java.io.UnsupportedEncodingException;
import org.apache.hadoop.io.Text;

/**
 * ClassName: CodeFormatter
 * @Description: 编码格式化类，用于将其他编码转换UTF-8,防止编码报错
 * @author 王宏
 * @date 2017年11月20日
 */
public class CodeFormatter {

	/**
	 * 将text转换字符编码为UTF-8
	 * @param text map输入的text的文本格式
	 * @param encoding 编码格式
	 * @return
	 */
	public static Text transformTextToUTF8(Text text, String encoding) {
		String value = null;
		try {
			value = new String(text.getBytes(), 0, text.getLength(), encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new Text(value);
	}
}
