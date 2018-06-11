package ml.jinggo.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author wangyj
 * @description
 * @create 2018-06-07 17:40
 **/
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{

    @Override
    public boolean matches(Method method, Class<?> clazz) {
        //1.切点方法匹配规则:方法名字为greetTo
        return "greetTo".equals(method.getName());
    }

    //2.切点类匹配规则：为watert的类或者子类
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }
}
