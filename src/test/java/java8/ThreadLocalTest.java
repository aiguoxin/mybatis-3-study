package java8;

/**
 * 2021/3/24 上午9:24
 * aiguoxin
 * 说明:
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> one = new ThreadLocal<>();
    private static ThreadLocal<String> two = new ThreadLocal<>();
    
    public static void main(String[] args) {
        one.set("a");
        two.set("b");
        System.out.println(one.get());
    }
}
