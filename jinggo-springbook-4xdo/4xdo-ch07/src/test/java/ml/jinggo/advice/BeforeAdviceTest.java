package ml.jinggo.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class BeforeAdviceTest {

    @Test
	public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice  advice = new GreetingBeforeAdvice();
        //1.spring 提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //2.设置代理目标 下面是JDK动态代理技术
        pf.setInterfaces(target.getClass().getInterfaces());
        pf.setOptimize(true);   //如果设置了优化，则是使用Cglib2AopProxy
        pf.setTarget(target);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter)pf.getProxy(); 
        proxy.greetTo("John");
        proxy.serveTo("Tom");
	}
}
