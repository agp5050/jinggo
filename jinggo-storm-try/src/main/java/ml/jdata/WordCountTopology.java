package ml.jdata;

import ml.jdata.demo.WordCountHBaseBolt;
import ml.jdata.demo.WordCountSplitBolt;
import ml.jdata.demo.WordCountSpout;
import ml.jdata.demo.WordCountTotalBolt;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.redis.bolt.RedisStoreBolt;
import org.apache.storm.redis.common.config.JedisPoolConfig;
import org.apache.storm.redis.common.mapper.RedisDataTypeDescription;
import org.apache.storm.redis.common.mapper.RedisStoreMapper;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.ITuple;

/**
 * @author wangyj
 * @description
 * @create 2018-05-28 15:22
 * 主程序
 **/
public class WordCountTopology {

    public static void main(String[] args) throws Exception{
        System.setProperty("hadoop.home.dir", "E:\\Tools\\hadoop-2.7.3");
        //创建任务构建器
        TopologyBuilder builder = new TopologyBuilder();

        //指定任务的spout组件
        builder.setSpout("mywordcountspout", new WordCountSpout());

        //指定任务的第一个bolt组件
        builder.setBolt("mywordcountsplit", new WordCountSplitBolt())
                .shuffleGrouping("mywordcountspout");//随机分组

        //指定任务的第二个bolt组件
        builder.setBolt("mywordcounttotal", new WordCountTotalBolt())
                .fieldsGrouping("mywordcountsplit", new Fields("word"));

//		//指定任务的第三个bolt组件，将结果写入Redis
//		builder.setBolt("mywordcountredisbolt", createRedisBolt())
//		       .shuffleGrouping("mywordcounttotal");

        //指定任务的第三个bolt组件，将结果写入HBase
        builder.setBolt("mywordcountredisbolt",new WordCountHBaseBolt())
                .shuffleGrouping("mywordcounttotal");


        //创建任务
        StormTopology job = builder.createTopology();

        Config conf = new Config();

        //任务有两种运行方式：1、本地模式   2、集群模式
        //1、本地模式
        LocalCluster localcluster = new LocalCluster();
        localcluster.submitTopology("MyWordCount", conf, job);

        //2、集群模式
//		StormSubmitter.submitTopology(args[0], conf, job);
    }

    private static IRichBolt createRedisBolt() {
        // 创建一个RedisBolt
        JedisPoolConfig.Builder builder = new JedisPoolConfig.Builder();
        builder.setHost("192.168.5.77");
        builder.setPort(6379);
        JedisPoolConfig pool = builder.build();

        //RedisStoreMapper指定redis数据格式
        return new RedisStoreBolt(pool, new RedisStoreMapper() {

            @Override
            public RedisDataTypeDescription getDataTypeDescription() {
                //保存结果的Redis的数据类型
                return new RedisDataTypeDescription(RedisDataTypeDescription.RedisDataType.HASH,
                        "result");
            }

            @Override
            public String getValueFromTuple(ITuple tuple) {
                return String.valueOf(tuple.getIntegerByField("total"));
            }

            @Override
            public String getKeyFromTuple(ITuple tuple) {
                return tuple.getStringByField("word");
            }
        });
    }
}
