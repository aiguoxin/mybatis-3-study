import java.util.concurrent.locks.Lock;

/**
 * 2020/9/14 下午11:27
 * aiguoxin
 * 说明:
 */
public class AutoLock implements AutoCloseable{

    private final Lock lock;

    public AutoLock(Lock lock){
        this.lock = lock;
        lock.lock();
    }

    @Override
    public void close() throws Exception {
        lock.unlock();
    }
}
