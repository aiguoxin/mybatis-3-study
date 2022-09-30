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
package java8;

import sun.misc.Contended;

/**
 * 2021/11/8 下午3:44
 * aiguoxin
 * 说明: 伪共享，当多线程修改互相独立的变量时，如果这些变量共享同一个缓存行，就会无意中影响彼此的性能
 * 增加-XX:-RestrictContended，及@Contended注解才生效
 */
public class FalseSharing {

    public static void main(String[] args) throws Exception{
       FalseSharing.testPointer(new Pointer());
    }

    private static void testPointer(Pointer pointer) throws Exception{
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100000000;i++){
                    pointer.x.value ++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100000000;i++){
                    pointer.y.value ++;
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(pointer);
    }

}


class Pointer{
    MyLong x = new MyLong();
    MyLong y = new MyLong();
}

@Contended
class MyLong{
    volatile long value;
}