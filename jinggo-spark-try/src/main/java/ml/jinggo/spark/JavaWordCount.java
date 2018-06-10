package ml.jinggo.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 * 集群模式的提交命令
 * bin/spark-submit --master spark://bigdata111:7077 --class demo.JavaWordCount /root/temp/sparkwc.jar hdfs://bigdata111:9000/input/data.txt
 */
public class JavaWordCount {
    public static void main(String[] args) {
        //指定任务的名称，
        SparkConf conf = new SparkConf();
        conf.setAppName("MyJavaWordCount");
        conf.setMaster("local");  //运行在本地模式上，如果是集群模式，需要去掉

        //创建SparkContext对象：使用Java版本的上下文
        JavaSparkContext context = new JavaSparkContext(conf);

        //读取数据
        //JavaRDD<String> lines = context.textFile(args[0]);
        JavaRDD<String> lines = context.textFile("hdfs://10.211.55.20:9000/input/word.txt");

        /*
         * 分词
         * FlatMapFunction<String, U>: String 表示源数据的类型
         *                             U:返回值的类型 String
         */
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

            @Override
            public Iterator<String> call(String data) throws Exception {
                //数据：data : I love Beijing
                return Arrays.asList(data.split(" ")).iterator();
            }
        });

        /*
         * 每个单词记一次数
         * 返回: (Beijing,1)
         * mapToPair：相当于MapReduce中的Map的输出类型
         * PairFunction<String, K2, V2>  String 每个单词  K2, V2是相当于Map的输出
         */
        JavaPairRDD<String, Integer> mapOutput = words.mapToPair(new PairFunction<String, String, Integer>() {

            @Override
            public Tuple2<String, Integer> call(String word) throws Exception {
                // Beijing ---> (Beijing,1)
                return new Tuple2<String, Integer>(word,1);
            }
        });

        //执行Reduce操作                                                               a         b       结果
        //(Beijing,3)
        JavaPairRDD<String, Integer> reduceOutput = mapOutput.reduceByKey(new Function2<Integer, Integer, Integer>() {

            @Override
            public Integer call(Integer a, Integer b) throws Exception {
                return a+b;
            }
        });

        //触发一个计算，并输出屏幕
        List<Tuple2<String, Integer>> finalResult = reduceOutput.collect();
        //reduceOutput.saveAsTextFile(path); ---> 输出到某个路径

        for(Tuple2<String, Integer> r: finalResult){
            System.out.println(r._1  + "\t" + r._2);
        }

        //停止Context对象
        context.stop();
    }
}
