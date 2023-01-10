package java8.aop;

import java.util.Objects;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

/**
 * 1/10/23 15:40
 * aiguoxin 
 * 说明:
 */
public class JavassitProxy {
    private Object bean;

    public JavassitProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory f = new ProxyFactory();
        f.setSuperclass(bean.getClass());
        f.setFilter(m -> Objects.equals("hello", m.getName()));

        Class c = f.createClass();
        MethodHandler methodHandler = (self, method, proceed, objects) -> {
            String methodName = method.getName();
            if (Objects.equals("hello", methodName)) {
                System.out.println("hello javassit~~");
            }
            return method.invoke(bean, objects);
        };
        Object proxy = c.newInstance();
        ((Proxy) proxy).setHandler(methodHandler);
        return proxy;
    }

    public static void main(String[] args) throws Exception {
        JavassitProxy proxy = new JavassitProxy(new Student("agx"));
        Student student = (Student) proxy.getProxy();
        System.out.println(student.hello());
    }
}
