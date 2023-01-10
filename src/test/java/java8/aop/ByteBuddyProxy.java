package java8.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * 1/10/23 15:49
 * aiguoxin
 * 说明: 基于ASM框架，应用于Mockito，java agent实现
 */
public class ByteBuddyProxy {
    private Object bean;

    public ByteBuddyProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() throws IllegalAccessException, InstantiationException {
        Object object = new ByteBuddy().subclass(bean.getClass())
                .method(ElementMatchers.named("hello"))
                .intercept(InvocationHandlerAdapter.of(new AopInvocationHandler(bean)))
                .make()
                .load(ByteBuddyProxy.class.getClassLoader())
                .getLoaded()
                .newInstance();
        return object;

    }

    public class AopInvocationHandler implements InvocationHandler {
        private Object bean;

        public AopInvocationHandler(Object bean) {
            this.bean = bean;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (Objects.equals(method.getName(), "hello")) {
                System.out.println("hello bytebuddy~~");
            }
            return method.invoke(bean, args);
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ByteBuddyProxy proxy = new ByteBuddyProxy(new Student("agx"));
        Student student = (Student) proxy.getProxy();
        System.out.println(student.hello());
    }
}
