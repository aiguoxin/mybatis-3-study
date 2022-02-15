package java8.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 2022/2/9 下午4:29
 * aiguoxin
 * 说明:
 */
public class jdkTest {
    public static void main(String[] args) {
//        OriginalI originalI = (OriginalI) Proxy.newProxyInstance(jdkTest.class.getClassLoader(),
//                Original.class.getInterfaces(), (proxy, method, args1) -> {
//                    method.invoke(new Original(), args1);
//                    System.out.println("after method...");
//                    return null;
//                });
        OriginalI originalI = (OriginalI) Proxy.newProxyInstance(OriginalI.class.getClassLoader(),
                Original.class.getInterfaces(), new JdkDynamic(new Original()));
        originalI.test();
    }


}

interface OriginalI {
    void test();
}

class Original implements OriginalI {
    @Override
    public void test() {
        System.out.println("test...");
    }
}

class JdkDynamic implements InvocationHandler {
    private Object object;
    public JdkDynamic(Object target){
        this.object = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /***此处一定需要使用被代理的对象，参数proxy没用到？**/
        method.invoke(object, args);
        System.out.println("after method...");
        return null;
    }
}
