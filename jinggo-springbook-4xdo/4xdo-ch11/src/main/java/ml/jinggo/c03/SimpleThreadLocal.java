package ml.jinggo.c03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyj
 * @description
 * @create 2018-07-16 17:29
 **/
public class SimpleThreadLocal {

    private Map valueMap = Collections.synchronizedMap(new HashMap<>());

    public void set(Object newValue) {
        //键为线程对象，值为本线程的变量副本
        valueMap.put(Thread.currentThread(),newValue);
    }

    public Object get(){
        Thread currentThread = Thread.currentThread();
        //返回本线程对应的变量
        Object o = valueMap.get(currentThread);
        if(o == null && !valueMap.containsKey(currentThread)) {
            o = intialValue();
            valueMap.put(currentThread,o);
        }
        return o;
    }

    public void remove(){
        valueMap.remove(Thread.currentThread());
    }

    public Object intialValue(){
        return  null;
    }
}
