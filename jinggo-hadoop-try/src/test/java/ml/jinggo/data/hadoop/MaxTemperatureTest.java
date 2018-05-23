package ml.jinggo.data.hadoop;

import ml.jinggo.data.mrunit.MaxTemperatureMapper;
import ml.jinggo.data.mrunit.MaxTemperatureReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author wangyj
 * @description
 * @create 2018-05-23 14:47
 **/
public class MaxTemperatureTest {

    private MapDriver mapDriver;
    private ReduceDriver reduceDriver;
    private MapReduceDriver mapReduceDriver;

    @Before
    public void setUp(){
        MaxTemperatureMapper mapper = new MaxTemperatureMapper();
        mapDriver = MapDriver.newMapDriver(mapper);
        MaxTemperatureReducer reducer = new MaxTemperatureReducer();
        reduceDriver = ReduceDriver.newReduceDriver();
        reduceDriver.withReducer(reducer);
        mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
    }

    @Test
    public void testMapper() throws IOException {
        Text text = new Text("0096007026999992016062218244+00000+000000FM-15+702699999V0209999C000019999999N999999999+03401+01801999999ADDMA1101731999999REMMET069MOBOB0 METAR 7026 //008 000000 221824Z AUTO 00000KT //// 34/18 A3004=");
        mapDriver.withInput(new LongWritable(), text);
        mapDriver.withOutput(new Text("2016"), new IntWritable(340));
        mapDriver.runTest();
        // 输出
        List<Pair> expectedOutputList = mapDriver.getExpectedOutputs();
        for(Pair pair : expectedOutputList){
            System.out.println(pair.getFirst() + " --- " + pair.getSecond()); // 2016 --- 340
        }
    }
}
