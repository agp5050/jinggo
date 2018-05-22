package ml.jinggo.data.mapred.serializable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-22 18:36
 **/
public class SalaryTotalReducer extends Reducer<IntWritable, Employee, IntWritable, IntWritable> {

    @Override
    protected void reduce(IntWritable k3, Iterable<Employee> v3,Context context)
            throws IOException, InterruptedException {
        //取出v3中的每个员工 进行工资求和
        int total = 0;
        for(Employee e:v3){
            total = total + e.getSal();
        }

        //输出
        context.write(k3, new IntWritable(total));
    }

}
