package ml.jinggo.data.mapreduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
/**
 * ClassName: SessionIdPartioner
 * @Description: 分区类,做完hash后取模
 * @author 王宏
 * @date 2017年11月20日
 */
public class SessionIdPartioner extends Partitioner<Text, Text>{
	
	@Override
	public int getPartition(Text key, Text value, int parts) {
		// 默认值
		String sessionid = "-";
		
		if(key != null){
			sessionid = key.toString().split("&")[0];
		}
		// 设置分区数数量
		int num = (sessionid.hashCode() & Integer.MAX_VALUE) % parts;
		return num;
	}		
}
