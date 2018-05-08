package ml.jinggo.data;

import ml.jinggo.data.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 读写分离
 * @author wangyj
 * @description
 * @create 2018-05-07 9:13
 **/
public class SpringJpaMasterSlaveOnlyMain {
    // CHECKSTYLE:OFF
    public static void main(final String[] args) {
        // CHECKSTYLE:ON
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/jpaMasterSlaveOnlyContext.xml");
        DemoService demoService = applicationContext.getBean(DemoService.class);
        demoService.demo();
    }
}
