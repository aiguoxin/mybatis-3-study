package java8.observer;

import java.util.Observable;
import java.util.Observer;
import org.junit.Test;

/**
 * 11/4/22 16:40
 * aiguoxin 
 * 说明: jdk 观察者test
 */
public class ObserverTest extends Observable{

    class Student implements Observer{
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("hello,i am student");
        }
    }

    class Teacher implements Observer{

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("hello,i am teacher");
        }
    }

    @Test
    public void testNotice(){
        ObserverTest observable = new ObserverTest();
        observable.addObserver(new Student());
        observable.addObserver(new Teacher());

        //protected方法，必须继承才允许调用。
        //通知前，必须打开开关，为啥需要这么个开关？https://zhuanlan.zhihu.com/p/25087260
        observable.setChanged();

        //加锁了，用来拷贝一份观察者名单，主要是为了防止有的观察者耗时太长，影响锁，具体看jdk说明
        observable.notifyObservers();
    }
}
