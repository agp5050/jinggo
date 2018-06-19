package ml.jinggo.advisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * @author wangyj
 * @description
 * @create 2018-06-11 9:25
 **/
public class GreetingComposablePointcut {
    public Pointcut getIntersectionPointcut(){
        ComposablePointcut cp = new ComposablePointcut();
        Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class,"service");
        NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
        pt2.addMethodName("greetTo");
        return cp.intersection(pt1).intersection((Pointcut)pt2);
    }
}
