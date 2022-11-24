package tools;

import com.google.common.util.concurrent.RateLimiter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 11/22/22 14:11
 * aiguoxin 
 * 说明: 限制1s内可以请求m次，滑动窗口的实现
 * 记录最后一次请求时间及已使用的token数
 *
 * TODO：看看guava如何实现的
 */
public class Limiter {

    private volatile Long limitTokenNum;
    private volatile Long usedTokenNum;
    private volatile Long lastReqTime;

    public Limiter(Long limitTokenNum) {
        this.limitTokenNum = limitTokenNum;
        this.lastReqTime = 0L;
        this.usedTokenNum = 0L;
    }

    public synchronized void tryGetToken() {
        System.out.println("start to get token...");
        Long currentTime = System.currentTimeMillis();
        if (usedTokenNum == limitTokenNum) {
            try {
                //需要计算可以使用时间点，休眠
                System.out.println("开始阻塞...currentTime=" + currentTime + ",lastReqTime=" + lastReqTime);
                long sleepTime = 1000 - (currentTime - lastReqTime);
                if (sleepTime > 0) {
                    System.out.println("开始阻塞...休眠=" + sleepTime + "ms");
                    TimeUnit.MILLISECONDS.sleep(sleepTime);
                }
                //休眠后，已用token置为0
                usedTokenNum = 0L;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        usedTokenNum++;
        lastReqTime = System.currentTimeMillis();
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

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Limiter limiter = new Limiter(2L);
        RateLimiter rateLimiter = RateLimiter.create(2.0);

        List<Runnable> tasks = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            tasks.add(new Worker("thread-" + i));
        }

        for (Runnable task : tasks) {
            /***test for guava limiter****/

            //方式一，可行，阻塞式获取
//            rateLimiter.acquire();
//            executor.submit(task);

            //方式二，可行
//            if (rateLimiter.tryAcquire(1, 2, TimeUnit.SECONDS)) {
//                executor.submit(task);
//            }

            //方式三，不可行，只会打印一条记录，就卡住了，WHY？因为默认是0超时，那就是接下来的请求由于获取不到token，全部扔掉了？
            //非阻塞式的，默认获取1个，
//            if (rateLimiter.tryAcquire()) {
//                executor.submit(task);
//            }

            //这是非阻塞式的，一次性就消费掉了，请求不会堵住。 下次可用之前，必须要sleep才可以！！
            limiter.tryGetToken();
            executor.submit(task);

//            boolean status = executor.awaitTermination(1, TimeUnit.SECONDS);

//            executor.shutdown();
//            System.out.println(status);
        }
    }
}
