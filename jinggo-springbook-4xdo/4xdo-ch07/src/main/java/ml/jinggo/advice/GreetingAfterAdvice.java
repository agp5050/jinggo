package ml.jinggo.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author wangyj
 * @description
 * @create 2018-06-07 10:14
 **/
public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnObj, Method method, Object[] args,
                               Object obj) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}
