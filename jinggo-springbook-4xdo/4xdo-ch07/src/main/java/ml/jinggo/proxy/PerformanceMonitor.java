package ml.jinggo.proxy;

/**
 * @author wangyj
 * @description
 * @create 2018-06-06 17:48
 **/
public class PerformanceMonitor {

    //1.通过ThreadLocal 保存与调用线程相关的性能监视
    private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<>();

    //2.启动对某一目标方法的性能监视
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformace mp = performaceRecord.get();
        if(mp == null){
            mp = new MethodPerformace(method);
            performaceRecord.set(mp);
        }else{
            mp.reset(method);
        }
    }

    //3.启动对某一目标方法的性能监视
    public static void end() {
        System.out.println("end monitor...");
        MethodPerformace mp = performaceRecord.get();
        mp.printPerformace();
    }
}
