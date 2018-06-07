package ml.jinggo.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author wangyj
 * @description
 * @create 2018-06-06 17:57
 **/
public class ForumService3Test {

    @Test
    public void proxy(){

        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);

        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
