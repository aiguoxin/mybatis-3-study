package java8.lambda;

/**
 * 1/9/23 21:01
 * aiguoxin 
 * 说明:https://juejin.cn/post/6844903902328930311
 * 测试lambda实现原理：生成静态内部类，调用生成的静态方法
 *
 */
public class DebugLambda {

    public static void printStr(String s, Print<String> print) {
        print.print(s);
    }

    public static void main(String[] args) {
        System.setProperty("jdk.internal.lambda.dumpProxyClasses","true");
        printStr("test", x -> System.out.println(x));
    }


    @FunctionalInterface
    interface Print<T> {
        void print(T x);
    }
}
