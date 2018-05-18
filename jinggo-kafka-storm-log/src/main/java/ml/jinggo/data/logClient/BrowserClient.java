package ml.jinggo.data.logClient;

import ml.jinggo.data.VO.BrowserLog;
import ml.jinggo.data.logDirector.BrowserDirector;
import ml.jinggo.data.logFactory.BrowserBuilder;
import ml.jinggo.data.logFactory.negativeConcrete.ConcreteBrowserBuilder;
import ml.jinggo.data.utils.GsonUtil;
import ml.jinggo.data.utils.KafkaUtil;
/**
 * 浏览器客户端，采用多线程来生产数据
 */
public class BrowserClient extends Thread{
    // 发送的Topic类型
    private static final String TOPIC = "browserLog";
    // 具体执行的application
    public static void app() {
        // 采用建造者来构造实例
        BrowserBuilder builder = new ConcreteBrowserBuilder();
        // 导演类，指定建造哪些对象
        BrowserDirector director = new BrowserDirector(builder);
        // kafkaUtil类，负责生产和发送数据
        KafkaUtil kafkaUtil = new KafkaUtil();
        // 生产10000000条数据
        for (int i = 0; i < 100; i++) {
            director.consturct();
            BrowserLog log = builder.retrieveResult();
            String json = GsonUtil.in(log);
            kafkaUtil.send(json, TOPIC);
        }
        kafkaUtil.close();
    }

    @Override
    public void run(){
        app();
    }

    public static void main(String[] args) {
        app();
    }
}
