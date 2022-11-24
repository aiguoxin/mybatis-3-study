package tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 11/24/22 16:15
 * aiguoxin 
 * 说明: 使用BlockQueue记录请求时间，好处是不用记录每次请求（如果用Map需要记录每一次）
 * 如果队列没满，则直接请求；如果队列满了，取出第一个时间戳first，用当前时间戳-first，再与1s比较，则是休眠时间
 */
public class RateLimiterA {
    private BlockingQueue<Long> blockingQueue;
    private Integer limitToken;

    public RateLimiterA(Integer limitToken) {
        this.limitToken = limitToken;
        this.blockingQueue = new LinkedBlockingQueue(limitToken);
    }

    public void tryAcquire() throws Exception {
        long requestTime = System.currentTimeMillis();
        if (blockingQueue.size() == limitToken) {
            //休眠
            long firstTime = blockingQueue.take();
            long minus = requestTime - firstTime;
            long sleepTime = 1000-minus;
            if(sleepTime > 0){
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            }
        }

        blockingQueue.add(System.currentTimeMillis());
    }

    static class Worker implements Runnable {
        String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "-request..." + new Date());
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        RateLimiterA limiter = new RateLimiterA(1);
        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            tasks.add(new Limiter.Worker("thread-" + i));
        }

        for (Runnable task : tasks) {
            limiter.tryAcquire();
            executor.submit(task);
        }
    }
}
