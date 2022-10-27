package java8.jcl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

/**
 * 10/26/22 11:00
 * aiguoxin 
 * 说明:  测试10个任务并发启动
 */
public class TestCyclicBarrier {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    CountDownLatch countDownLatch = new CountDownLatch(10);
    Semaphore semaphore = new Semaphore(10);

    /**线程池大小>并发数，否则就不会执行start**/
    ExecutorService executorService = Executors.newFixedThreadPool(20);

    @Test
    public void testByCyclicBarrier() {
        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask();
            executorService.submit(task);
        }
    }

    @Test
    public void testByCountDownLatch() {
        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask();
            executorService.submit(task);
            countDownLatch.countDown();
        }
    }

    @Test
    public void testSemaphore() {
       //todo 模拟连接池
    }

    class MyTask implements Runnable {

        @Override
        public void run() {
            int count = atomicInteger.incrementAndGet();
            System.out.println("prepare------------" + count);

            try {
//                cyclicBarrier.await();
                countDownLatch.await();

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("start------------" + count);

        }
    }
}
