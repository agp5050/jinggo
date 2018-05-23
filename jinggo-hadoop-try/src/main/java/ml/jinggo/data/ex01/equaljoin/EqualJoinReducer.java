package ml.jinggo.data.ex01.equaljoin;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-23 10:25
 **/
//                                                               k4 部门名称    v4 所有员工的名字
public class EqualJoinReducer extends Reducer<IntWritable, Text, Text, Text> {

    @Override
    protected void reduce(IntWritable k3, Iterable<Text> v3, Context context)
            throws IOException, InterruptedException {
        //从value3中解析出 部门名称 和员工姓名
        String dname = "";  //部门名称
        String empListName = "";//所有员工的姓名

        for(Text str:v3){
            String name = str.toString();

            //判断是否存储*号
            int index = name.indexOf("*");
            if(index >=0){
                //是部门名称，去掉第一个*号
                dname = name.substring(1);
            }else{
                //是员工的姓名
                empListName = name+";"+empListName;
            }
        }

        //输出
        context.write(new Text(dname), new Text(empListName));
    }
}

