package ml.jinggo.data.mapred.offset;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-22 17:57
 **/
public class OffSetMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

    @Override
    protected void map(LongWritable k1, Text v1, Context context)
            throws IOException, InterruptedException {
        //不进行任何处理，直接输出 k1 v1
        context.write(k1, v1);
    }

}
