/**
 *    Copyright 2009-2022 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //jdk代理，只能赋值给接口，不能是实现类original!!
        OriginalI originalI = (OriginalI) Proxy.newProxyInstance(OriginalI.class.getClassLoader(),
                Original.class.getInterfaces(), new JdkDynamic(new Original()));
        originalI.test();
    }


}

interface OriginalI {
    String test();
}

class Original implements OriginalI {
    @Override
    public String test() {
        return "hello";
    }
}

class JdkDynamic implements InvocationHandler {
    private Object object;

    public JdkDynamic(Object target) {
        this.object = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /***此处一定需要使用被代理的对象，参数proxy没用到？**/
        Object result = method.invoke(object, args);
        System.out.println("after method..." + result);
        return result;
    }
}
