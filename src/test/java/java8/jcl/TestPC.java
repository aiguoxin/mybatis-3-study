package java8.jcl;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;
import org.junit.Test;

/**
 * 10/25/22 17:51
 * aiguoxin 
 * 说明: LinkedBlockingQueue模拟生产消费者
 */
public class TestPC {
    Queue blockingQueue = new LinkedBlockingQueue();

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MProducer producer = new MProducer();
        MConsumer consumer = new MConsumer();

        executorService.submit(producer);
        executorService.submit(consumer);

        LockSupport.parkNanos(100000);
//        producer.stop();
//        consumer.stop();
    }

    class MProducer implements Runnable {
        boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                blockingQueue.add("msg");
            }
        }

        public void stop() {
            flag = false;
        }
    }

    class MConsumer implements Runnable {
        boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                String msg = String.valueOf(blockingQueue.poll());
                System.out.println(msg);
            }
        }

        public void stop() {
            flag = false;
        }
    }
}
