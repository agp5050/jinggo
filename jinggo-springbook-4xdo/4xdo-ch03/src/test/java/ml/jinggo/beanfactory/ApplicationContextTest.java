package ml.jinggo.beanfactory;

import ml.jinggo.domain.Beans;
import ml.jinggo.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangyj
 * @description
 * @create 2018-05-30 16:26
 **/
public class ApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car =ctx.getBean("car",Car.class);
    }
}
