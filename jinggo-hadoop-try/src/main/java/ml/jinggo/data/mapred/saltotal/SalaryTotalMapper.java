package ml.jinggo.data.mapred.saltotal;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-22 18:19
 **/
public class SalaryTotalMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {

    @Override
    protected void map(LongWritable key1, Text value1,Context context)
            throws IOException, InterruptedException {
        //数据：7654,MARTIN,SALESMAN,7698,1981/9/28,1250,1400,30
        String data = value1.toString();

        //分词
        String[] words = data.split(",");

        //输出：k2 部门号    v2  薪水
        context.write(new IntWritable(Integer.parseInt(words[7])),  //部门号
                new IntWritable(Integer.parseInt(words[5]))); //薪水
    }

}