package ml.jinggo.data.ex01.combiner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-23 9:48
 **/
//                                                                k2常量      v2工资
public class AvgSalaryMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key1, Text value1, Context context)
            throws IOException, InterruptedException {
        // 数据：7654,MARTIN,SALESMAN,7698,1981/9/28,1250,1400,30
        String data = value1.toString();

        //分词
        String[] words = data.split(",");

        context.write(new Text("sal"), new IntWritable(Integer.parseInt(words[5])));
    }

}

