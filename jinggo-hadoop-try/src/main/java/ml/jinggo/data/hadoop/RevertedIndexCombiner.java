package ml.jinggo.data.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-23 14:16
 **/
public class RevertedIndexCombiner extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text k21, Iterable<Text> v21, Context context)
            throws IOException, InterruptedException {
        // 求和：对同一个文件中，每个单词的频率求和
        int total = 0;
        for(Text v:v21){
            total = total + Integer.parseInt(v.toString());
        }

        //输出
        //分离：单词和文件名      k21: love:data01.txt
        String data = k21.toString();
        //找到冒号的位置
        int index = data.indexOf(":");

        String word = data.substring(0, index);  //单词
        String fileName = data.substring(index+1);//文件名

        //输出
        context.write(new Text(word), new Text(fileName+":"+total));
    }
}
