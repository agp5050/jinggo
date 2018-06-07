package ml.jinggo.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author wangyj
 * @description
 * @create 2018-06-06 17:57
 **/
public class ForumService2Test {

    @Test
    public void proxy(){
        ForumService target = new ForumServiceImpl();
        PerformaceHandler handler = new PerformaceHandler(target);

        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);

        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
