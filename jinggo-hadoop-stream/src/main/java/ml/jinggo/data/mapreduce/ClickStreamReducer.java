package ml.jinggo.data.mapreduce;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/**
 * ClassName: ClickStreamReducer
 * @Description: MRreducer类，主要负责输出数据，和简单计数。
 * @author 王宏
 * @date 2017年11月20日
 */
public class ClickStreamReducer extends Reducer<Text, Text, NullWritable, Text>{

	/**
	 * @Fields preSessionId : 表示前一个sessionId
	 */
	public static String preSessionId = "-";//66：改进版把他变为静态变量
	/**
	 * @Fields csvp : 改进版把csvp变为静态变量，并移到成员函数外面
	 */
	static int csvp = 0;
	
	/* (non-Javadoc)
	 * @see org.apache.hadoop.mapreduce.Reducer#reduce(KEYIN, java.lang.Iterable, org.apache.hadoop.mapreduce.Reducer.Context)
	 */
	protected void reduce(Text key, Iterable<Text> values, Context context) throws java.io.IOException ,InterruptedException {
		
		String sessionId = key.toString().split("&")[0];		
		
		//如果是第一条数据
		if(preSessionId.equals("-")){
			csvp = 1;
			preSessionId = sessionId;
		}else{
			//改进版，新加入这句，不然逻辑不完整
			if(preSessionId.equals(sessionId)){
				//累加csvp
				csvp++;
			//如果不同，说明是新的session,重置preSessionId 和 csvp
			}else{
				preSessionId = sessionId;
				csvp = 1;
			}
		}
		
		//按照clickstream_log的格式再末尾加上csvp
		String reduceOutValue = values.iterator().next().toString() + "\t" + csvp;
		context.write(NullWritable.get(), new Text(reduceOutValue));
	};
}
