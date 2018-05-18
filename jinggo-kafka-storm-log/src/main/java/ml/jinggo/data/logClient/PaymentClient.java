package ml.jinggo.data.logClient;


import ml.jinggo.data.VO.PaymentInfo;
import ml.jinggo.data.logDirector.PaymentDirector;
import ml.jinggo.data.logFactory.PaymentBuilder;
import ml.jinggo.data.logFactory.negativeConcrete.ConcretePaymentBuilder;
import ml.jinggo.data.utils.GsonUtil;
import ml.jinggo.data.utils.KafkaUtil;

/**
 * 支付类,采用多线程生产数据
 */
public class PaymentClient extends Thread{
    // 发送的topic类
    private static final String TOPIC = "paymentInfo";
    /**
     * 具体负责执行的application类
     */
    public static void app() {
        // 建造者类，负责构造具体的实例
        PaymentBuilder builder = new ConcretePaymentBuilder();
        // 导演类，负责构造具体的实例
        PaymentDirector director = new PaymentDirector(builder);
        // KafkaUtil类，负责发送和生产对应数据
        KafkaUtil kafkaUtil = new KafkaUtil();
        // 发送1000000条数据
        for (int i = 0; i < 100; i++) {
            director.construct();
            PaymentInfo info = builder.retrieveResult();
            String json = GsonUtil.in(info);
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
