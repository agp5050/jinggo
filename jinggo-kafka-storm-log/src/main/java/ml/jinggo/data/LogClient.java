package ml.jinggo.data;

import ml.jinggo.data.logClient.BrowserClient;
import ml.jinggo.data.logClient.PaymentClient;
import ml.jinggo.data.logClient.RuleClient;

/**
 * 客户端启动工具类,采用多线程启动，不用等一个类运行完毕再等待另一个.
 */
public class LogClient {
    // 执行实体类
    public static void run() {
        new Thread(new BrowserClient()).start();
        new Thread(new PaymentClient()).start();
        new Thread(new RuleClient()).start();
    }

    public static void main(String[] args) {
        run();
    }
}
