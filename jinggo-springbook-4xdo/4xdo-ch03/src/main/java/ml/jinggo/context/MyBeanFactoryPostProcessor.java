package ml.jinggo.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author wangyj
 * @description
 * @create 2018-05-30 16:18
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        //application 启动时候，先将配置文件中每个bean 生成一个 BeanDefinition 对象
        BeanDefinition bd = bf.getBeanDefinition("car");
        bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
        System.out.println("调用MyBeanFactoryPostProcessor.postProcessBeanFactory()！");
    }
}
