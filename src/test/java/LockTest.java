import java.util.concurrent.locks.ReentrantLock;

/**
 * 2020/9/14 下午11:42
 * aiguoxin
 * 说明:
 */
public class LockTest {
    private final static ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(() -> {
//                new AutoLock(REENTRANT_LOCK)这样会报错
                try(AutoLock autoLock = new AutoLock(REENTRANT_LOCK)){
                    System.out.println("lock....");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
