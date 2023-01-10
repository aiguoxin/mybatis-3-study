package java8.aop;

import java.lang.reflect.Method;
import java.util.Objects;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 1/10/23 15:24
 * aiguoxin 
 * 说明: 底层基于ASM框架
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    private Object bean;

    public CglibProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() {
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        if (Objects.equals("hello", methodName)) {
            System.out.println("hello~~");
        }
        return method.invoke(bean, objects);
    }

    public static void main(String[] args) {
        /***Student必须要用无参构造器，否则会报错！！***/
        CglibProxy proxy = new CglibProxy(new Student("agx"));
        Student student = (Student) proxy.getProxy();
        System.out.println(student.hello());
    }
}
