package ml.jdata.demo;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * @author wangyj
 * @description
 * @create 2018-05-28 14:57
 **/
//第一个bolt组件：单词拆分
public class WordCountSplitBolt extends BaseRichBolt {

    //collector：该bolt组件的收集器，用于把处理的数据发给下一个bolt组件
    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        // 初始化
        //collector：该bolt组件的收集器，用于把处理的数据发给下一个bolt组件
        this.collector = collector;
    }

    @Override
    public void execute(Tuple tuple) {
        //如何处理上一级发来的数据: I love Beijing
        String value = tuple.getStringByField("sentence");
        //分词
        String[] words = value.split(" ");
        //输出
        for(String w:words){
            collector.emit(new Values(w,1));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declare) {
        // 申明发送给下一个组建的tuple的schema（结构）
        declare.declare(new Fields("word","count"));
    }
}
