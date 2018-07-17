package ml.jinggo.c03;

/**
 * @author wangyj
 * @description
 * @create 2018-07-17 10:56
 **/
public class SequenceNumber {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        public Integer initialValue(){
            return 0;
        }
    };

    public int getNextNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        TestClinet t1 = new TestClinet(sn);
        TestClinet t2 = new TestClinet(sn);
        TestClinet t3 = new TestClinet(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClinet extends Thread {
        private SequenceNumber sn;

        public TestClinet(SequenceNumber sn) {
            this.sn = sn;
        }
        public void run(){
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread["+Thread.currentThread().getName()+"] sn["+sn.getNextNum()+"]");
            }
        }
    }
}
