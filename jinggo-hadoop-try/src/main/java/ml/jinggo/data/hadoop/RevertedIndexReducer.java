package ml.jinggo.data.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-23 14:15
 **/
public class RevertedIndexReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text k3, Iterable<Text> v3, Context context)
            throws IOException, InterruptedException {
        //对combiner的输出的value  拼加
        String str = "";
        for(Text t:v3){
            str = "(" + t.toString()+")" + str;
        }

        context.write(k3, new Text(str));
    }

}
