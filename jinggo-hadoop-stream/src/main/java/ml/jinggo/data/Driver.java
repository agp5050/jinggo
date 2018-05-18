package ml.jinggo.data;

import java.io.IOException;

import ml.jinggo.data.mapreduce.ClickStreamMapper;
import ml.jinggo.data.mapreduce.ClickStreamReducer;
import ml.jinggo.data.mapreduce.SessionIdPartioner;
import ml.jinggo.data.mapreduce.SortComparator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
/**
 * ClassName: Driver
 * @Description: MR程序主类，负责处理程序调度。
 * @author 王宏
 * @date 2017年11月20日
 */
public class Driver {
	/**
	 * @Description: 程序处理入口
	 * @param args 两个参数，程序文件输入路径和程序文件输出路径
	 * @return void  
	 * @throws 
	 * @author 王宏
	 * @date 2017年11月20日
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		// 程序在本地调试，需要指定程序版本。
		System.setProperty("hadoop.home.dir", "D:\\hadoop\\hadoop-2.6.5");

		Configuration configuration = new Configuration();

		if (args.length != 2) {
			System.out.println("Wrong Parameter");
			return;
		}
		// 输入的路径
		String inputPath = args[0];
		// 输出的路径
		String outputPath = args[1]+new java.util.Random().nextInt(1000);

		@SuppressWarnings("deprecation")
		Job job = new Job(configuration, "clickstream_etl");
		job.setJarByClass(Driver.class);
		FileInputFormat.addInputPath(job, new Path(inputPath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath));
		// mapper类设置
		job.setMapperClass(ClickStreamMapper.class);
		// reducer类设置
		job.setReducerClass(ClickStreamReducer.class);
		// Reducer 任务数设置
		job.setNumReduceTasks(1); 
		// 指定格式化输出类型，这里指定默认类
		job.setOutputFormatClass(TextOutputFormat.class);
		// 指定分区类
		job.setPartitionerClass(SessionIdPartioner.class);
		// 指定排序类
		job.setSortComparatorClass(SortComparator.class);
		// 设置key 输出类型
		job.setOutputKeyClass(Text.class);
		// 设置value 输出类型
		job.setOutputValueClass(Text.class);
		// 程序完毕时结束
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
