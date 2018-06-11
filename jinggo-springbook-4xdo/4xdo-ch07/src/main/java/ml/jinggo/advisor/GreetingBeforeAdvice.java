package ml.jinggo.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author wangyj
 * @description
 * @create 2018-06-08 9:13
 **/
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object obj) throws Throwable {
        String clientName = (String)args[0];
        System.out.println(obj.getClass().getName()+"."+method.getName());
        System.out.println("How are you！Mr."+clientName+".");
    }
}
