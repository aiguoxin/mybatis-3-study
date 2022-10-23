/**
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package cas;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/** 2020/9/13 下午8:58 aiguoxin 说明: 使用锁、CAS（Compare And Swap）、FAA（Fetch and Add）实现转账 */
public class Account {
    private static int balance = 0;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(20);
    static ReentrantLock lock = new ReentrantLock();
    static CountDownLatch latch = new CountDownLatch(1000);
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        //        useLock();
        useCAS();
        //        useFAA();
    }

    private static void useFAA() {
        List<CompletableFuture> list = Lists.newArrayList();
        for (int init = 0; init < 1000; init++) {
            CompletableFuture future =
                    CompletableFuture.runAsync(
                            () -> {
                                balance = atomicInteger.getAndAdd(1);
                            });
            list.add(future);
        }
        for (CompletableFuture feature : list) {
            try {
                feature.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("balance is " + balance);
    }

    private static void useCAS() {
        List<CompletableFuture> list = Lists.newArrayList();
        for (int init = 0; init < 1000; init++) {
            CompletableFuture future =
                    CompletableFuture.runAsync(
                            () -> {
                                while (true) {
                                    int oldVal = atomicInteger.get();
                                    balance = oldVal + 1;
                                    if (atomicInteger.compareAndSet(oldVal, balance)) {
                                        break;
                                    }
                                }
                                //                               balance =
                                // atomicInteger.incrementAndGet();
                            });
            list.add(future);
        }
        for (CompletableFuture feature : list) {
            try {
                feature.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("balance is " + balance);
    }

    private static void useLock() throws InterruptedException {
        for (int init = 0; init < 1000; init++) {
            threadPool.submit(
                    () -> {
                        lock.lock();
                        try {
                            balance++;
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                            latch.countDown();
                        }
                        return balance;
                    });
        }
        latch.await();
        System.out.println("balance is " + balance);
        threadPool.shutdown();
    }
}
