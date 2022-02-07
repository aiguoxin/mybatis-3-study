package java8.generics;

/**
 * 2022/1/30 上午10:57
 * aiguoxin
 * 说明:
 */
public class A<T> {
    public static <T> void test(T t){
        System.out.println(t.toString());
    }

    /**static方法无法感知T，报错**/
//    public static void test1(T t){
//        System.out.println(t.toString());
//    }
}
