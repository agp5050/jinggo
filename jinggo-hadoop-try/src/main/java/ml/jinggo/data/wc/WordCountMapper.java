package ml.jinggo.data.wc;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-04-25 17:33
 **/
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

    @Override
    protected void map(LongWritable key1, Text value1, Context context) throws IOException, InterruptedException {

        //1.取出数据
        String data= value1.toString();

        //2.分词
        String[] words = data.split(" ");
        
        //输出
        for (String world : words) {
            context.write(new Text(world), new IntWritable(1));
        }
    }
}
