package ml.jinggo.data.ex01.distinct;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-23 10:04
 **/
public class DistinctReducer extends Reducer<Text, NullWritable, Text, NullWritable> {

    @Override
    protected void reduce(Text k3, Iterable<NullWritable> v3,Context context) throws IOException, InterruptedException {
        //直接输出
        context.write(k3, NullWritable.get());
    }

}
