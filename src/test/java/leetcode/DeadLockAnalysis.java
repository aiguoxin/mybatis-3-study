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
