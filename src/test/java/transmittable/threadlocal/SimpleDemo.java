/**
 *    Copyright 2009-2020 the original author or authors.
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
package transmittable.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlCallable;

import java.util.concurrent.*;

/** 2020/8/31 上午11:31 aiguoxin 说明: */

/**
 * ThreadLocal、InheritableThreadLocal的最大局限性就是：无法为预先创建好（未投入使用）的线程实例传递变量
 * （准确来说是首次传递某些场景是可行的，而后面由于线程池中的线程是复用的，无法进行更新或者修改变量的传递值
 *
 * 框架的骨架。
 * 核心类TransmittableThreadLocal。
 * 发射器Transmitter。 捕获、重放和复原。
 * Agent模块。
 */
public class SimpleDemo {
    static InheritableThreadLocal<String> test = new InheritableThreadLocal<>();
    static TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();
    static ExecutorService poolService = Executors.newSingleThreadExecutor();
    static ThreadPoolExecutor selfDefinePoolService =
            new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
//        预先启动所有线程，此时结果会怎么样？
//        selfDefinePoolService.prestartAllCoreThreads();
//        获取不到任何值，因为线程是预先创建好，此时，尚未设置threadlocal值

        test.set("go");
        context.set("before");
        //        new Thread(
        //                        () -> {
        //                            String value = context.get();
        //                            System.out.println("value=" + value);
        //                            System.out.println("test=" + test.get());
        //                        })
        //                .start();
        //        poolService.submit(TtlCallable.get(new CallableTask()));
        selfDefinePoolService.submit(TtlCallable.get(new CallableTask()));

        context.set("after");
        //        poolService.submit(TtlCallable.get(new CallableTask()));
        selfDefinePoolService.submit(TtlCallable.get(new CallableTask()));

        poolService.shutdown();
        selfDefinePoolService.shutdown();
    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("value=" + context.get());
            return 5;
        }
    }
}
