package ml.jinggo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 分布式锁
 * @author wangyj
 * @description
 * @create 2018-07-17 17:31
 **/
public class DistributedLock {

    private static int count = 10;

    private static void printCountNumber(){
        System.out.println("============start==============");
        System.out.println("当前值：" + count);
        count --;

        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("============end==============");
    }

    public static void main(String[] args) {
        //1.定义客户端重试策略                               每次等待的时间         最大重试的次数
        RetryPolicy policy = new ExponentialBackoffRetry(1000, 10);

        //2.定义zk的一个客户端
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("192.168.1.222:2181")
                .retryPolicy(policy)
                .build();

        //在ZK 生成锁 --->就是zk 的目录
        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client,"/mylock");

        //启动10 个线程去访问共享资源
        for (int i = 0; i < 10; i++) {
            new Thread((new Runnable() {
                @Override
                public void run() {
                    try{
                        //请求得到锁
                        lock.acquire();

                        //访问共享资源
                        printCountNumber();
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        //释放锁
                        try {
                            lock.release();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            })).start();
        }
    }
}
