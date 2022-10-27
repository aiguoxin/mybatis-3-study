package java8.gc;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 10/26/22 16:21
 * aiguoxin
 * 请写一段程序，让其运行时的表现为触发5次ygc，然后3次fgc，然后3次ygc，然后1次fgc，请给出代码以及启动参数。
 *
 * 说明: -Xms41m -Xmx41m -Xmn10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 * 堆内存=41M，年轻代：10M=eden(8M)+s1(1M)+s2(1M)，年老代=20M，与年轻代比例2:1
 *
 * 总结上面分析的策略，可以看到采用Parallel GC的情况下，当YGC触发时，会有两个检查：
 1、在YGC执行前，min(目前新生代已使用的大小,之前平均晋升到old的大小中的较小值) > 旧生代剩余空间大小 ? 不执行YGC，直接执行Full GC : 执行YGC；
 2、在YGC执行后，平均晋升到old的大小 > 旧生代剩余空间大小 ? 触发Full GC ： 什么都不做。
 */
public class GcTest {

    @Test
    public void testGc() {
        int UNIT_MB = 1024 * 1024;
//        getJvmInfo();
        int count = 1;
        List caches = new ArrayList();
        System.out.println("--初始化时已用堆值:" + ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / (1024 * 1024) + "M");
        for (int i = 1; i <= 12; i++) {
            if (i == 11) {
                System.out.println("--caches准备添加第11次,old区内存不够，开始full GC 前先执行minor GC 第" + 5 + "次,FGC 第1次(触发条件：【MinorGC后存活的对象超过了老年代剩余空间】)");
            }
            caches.add(new byte[3 * UNIT_MB]);
            if (i % 2 == 0 && i != 10) {
                System.out.println("--caches添加第" + i + "次后，eden + survivor 的内存不够，开始minor GC 第" + count + "次");
                count++;
            } else {
                System.out.println("--caches添加第" + i + "次");
            }
        }
        System.out.println("目前整个堆内存已经36m多，Young区6M多，Old区最大值为32M");
        caches.remove(0);//释放空间，重新添加 ,如果不释放空间，会报错：java.lang.OutOfMemoryError: Java heap space 【这里这样做，主要为了防止数组对象实际大小超过堆大小】
        System.out.println("--FGC开始 第2次（触发条件：晋升到老年代的大小超过了老年代剩余大小）");
        caches.add(new byte[3 * UNIT_MB]);
        System.out.println("本次FGC，移植了Young区的一部分到Old区，导致Young区还有3M左右");
        for (int i = 0; i < 8; i++) {//这里是为了下次FGC后，直接减少老年代的内存大小，从而正常YGC
            caches.remove(0);
        }
        System.out.println("--FGC开始 第3次(触发条件:同上)");
        caches.add(new byte[3 * UNIT_MB]);

        for (int i = 0; i < 6; i++) {
            caches.add(new byte[3 * UNIT_MB]);
        }
    }


    @Test
    public void testAli() {
        /***-Xms30m -Xmx30m -Xmn10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps***/
        //结果M、M、M、M、F、F，即4次YGC，2次FGC

        /***-Xms30m -Xmx30m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps***/
        //结果M、M、M、M、F，即4次YGC，1次FGC，但是没有打印FGC，https://blog.51cto.com/u_5650011/5390309

        List caches = new ArrayList();
        for (int i = 0; i < 7; i++) {
            System.out.println("------"+i);
            caches.add(new byte[1024 * 1024 * 3]);
        }
        caches.clear();
        for (int i = 7; i < 9; i++) {
            caches.add(new byte[1024 * 1024 * 3]);
        }

    }
}
