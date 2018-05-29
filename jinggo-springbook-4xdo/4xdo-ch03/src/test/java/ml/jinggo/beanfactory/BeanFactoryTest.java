package ml.jinggo.beanfactory;

import ml.jinggo.domain.Car;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author wangyj
 * @description
 * @create 2018-05-29 10:41
 **/
public class BeanFactoryTest {

    @Test
    public void getBean() throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:xml/beanfactory.xml");

        System.out.println(res.getURL());

        //被废弃，不建议使用
        //BeanFactory bf= new XmlBeanFactory(res);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        System.out.println("init Beanfactory.");

        Car car = factory.getBean("car",Car.class);
        System.out.println("car bean is ready for use");
        car.introduce();
    }
}
