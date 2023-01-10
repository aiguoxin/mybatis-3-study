package java8.aop;

/**
 * 1/10/23 10:14
 * aiguoxin 
 * 说明: 静态代理测试
 * 缺点：
 * 1. 需要实现Proxy类，接口方法越多，需要代理的接口越多，不通用。
 * 2. 接口HttpApi变化了，Real和Proxy都需要改
 * JDK动态代理则可避免
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Real());
        System.out.println(proxy.get("test"));
    }

    interface HttpApi {
        String get(String url);
    }

    static class Real implements HttpApi {

        @Override
        public String get(String url) {
            return url;
        }
    }

    static class Proxy implements HttpApi {
        private HttpApi target;

        public Proxy(HttpApi target) {
            this.target = target;
        }

        @Override
        public String get(String url) {
            return target.get(url);
        }
    }
}
