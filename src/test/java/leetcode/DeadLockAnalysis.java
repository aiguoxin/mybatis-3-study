/**
 *    Copyright 2009-2021 the original author or authors.
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
package leetcode;

import java.util.concurrent.TimeUnit;

/**
 * 2020/10/4 下午9:50
 * aiguoxin
 * 说明: 死锁例子，blocked
 */
public class DeadLockAnalysis {
    private static Object lockOne = new Object();
    private static Object lockTwo = new Object();

    private void testLockOne(){
        synchronized (lockOne){
            System.out.println("locked by one...testLockOne");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockTwo){
                System.out.println("locked by two~~~~testLockOne");
            }
        }
    }

    private void testLockTwo(){
        synchronized (lockTwo){
            System.out.println("locked by two~~~~testLockTwo");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockOne){
                System.out.println("locked by one...testLockTwo");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockAnalysis deadLockAnalysis =  new DeadLockAnalysis();
        new Thread(() -> deadLockAnalysis.testLockOne()).start();
        new Thread(() -> deadLockAnalysis.testLockTwo()).start();
    }
}
