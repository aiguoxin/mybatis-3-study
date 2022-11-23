package tools;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 11/22/22 14:11
 * aiguoxin 
 * 说明: 限制1s内可以请求m次，滑动窗口的实现
 * 记录最后一次请求时间及已使用的toke数
 *
 * TODO：看看guava如何实现的
 */
public class Limiter {
    static Limiter limiter = new Limiter(2L);

    private volatile Long limitTokenNum;
    private volatile Long usedTokenNum;
    private volatile Long lastReqTime;

    public Limiter(Long limitTokenNum) {
        this.limitTokenNum = limitTokenNum;
        this.lastReqTime = System.currentTimeMillis();
        this.usedTokenNum = 0L;
    }

    public boolean tryGetToken() {
        Long currentTime = System.currentTimeMillis();
        boolean gteOneSecond = (currentTime - lastReqTime) / 1000 >= 1 ? true : false;

        //如果cur - lastReqTime  >= 1s，则可以请求，currentTokenNum-1
        if (gteOneSecond) {
            usedTokenNum = 1L;
            lastReqTime = currentTime;
            return true;
        }

        //如果cur - lastReqTime  < 1s, limitTokenNum-(limitTokenNum-currentTokenNum)可放入的，如果小于1，拒绝。否则，可以请求
        long availTokenNum = limitTokenNum - usedTokenNum;
        if (availTokenNum < 1) {
            return false;
        } else {
            usedTokenNum ++;
            lastReqTime = currentTime;
            return true;
        }
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            if (limiter.tryGetToken()) {
                System.out.println("request..." + new Date());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            /****一次提交1000个，那只能输出2个，因为限流了，得1s提交3个，查看是否只输出了限制的个数！！！！！****/
            executor.submit(new Worker());
//            if (limiter.tryGetToken()) {
//                System.out.println("request..." + new Date());
//            }
//            Thread.sleep(100);
        }
    }
}
