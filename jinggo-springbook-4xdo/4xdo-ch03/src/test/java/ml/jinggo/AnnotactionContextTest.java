package ml.jinggo;

import ml.jinggo.domain.Beans;
import ml.jinggo.domain.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author wangyj
 * @description
 * @create 2018-05-29 11:24
 **/
public class AnnotactionContextTest {

    @Test
    public void getBean(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car",Car.class);
        assertNotNull(car);
    }
}
