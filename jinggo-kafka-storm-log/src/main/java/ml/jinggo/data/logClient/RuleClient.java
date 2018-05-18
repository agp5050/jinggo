package ml.jinggo.data.logClient;


import ml.jinggo.data.VO.RuleInfo;
import ml.jinggo.data.logDirector.RuleDirector;
import ml.jinggo.data.logFactory.RuleBuilder;
import ml.jinggo.data.logFactory.positiveConcrete.ConcreteRuleBuilder;
import ml.jinggo.data.utils.GsonUtil;
import ml.jinggo.data.utils.KafkaUtil;

import java.io.FileNotFoundException;

/**
 * 规则实例类，采用多线程发送数据
 */
public class RuleClient extends Thread{
    // 定义的Topic类
    private static final String TOPIC = "ruleInfo";
    // 负责具体执行的application实例类
    public static void app() {
        RuleBuilder builder = (RuleBuilder) new ConcreteRuleBuilder();
        RuleDirector director = new RuleDirector(builder);
        KafkaUtil kafkaUtil = new KafkaUtil();
        for (int i = 0; i < 100; i++) {
            director.construct();
            RuleInfo info = builder.retrieveResult();
            String json = GsonUtil.in(info);
            kafkaUtil.send(json, TOPIC);
        }
        kafkaUtil.close();
    }
    @Override
    public void run(){
        app();
    }

    public static void main(String[] args) throws FileNotFoundException {
        app();
//        System.out.println(((RuleInfo) Dom4j.pojo(Dom4j.xml(info, "UTF-8"), info)).getIsCashonDelivery());
    }
}
