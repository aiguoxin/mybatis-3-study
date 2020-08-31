package transmittable.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

/** 2020/8/31 上午11:31 aiguoxin 说明: */
public class SimpleDemo {
    public static void main(String[] args) {
        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();
        context.set("value-set-in-parent");
        new Thread(
                        () -> {
                            String value = context.get();
                            System.out.println("value=" + value);
                        })
                .start();
    }
}
