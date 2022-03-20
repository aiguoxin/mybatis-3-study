package java8.solid.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2022/3/17 下午5:40
 * aiguoxin 
 * 说明: LSP 里氏替换原则测试
 */
public class ClientTest {
    static class Father {
//        Collection doSomething(HashMap map) {
//            System.out.println("father doSomething ....");
//            return map.values();
//        }

        Set doSomething(HashMap map){
            System.out.println("child doSomething result is set....");
            return new HashSet();
        }

        Collection doSomething2(Map map) {
            System.out.println("father doSomething2 ....");
            return map.values();
        }
    }

    static class Son extends Father {
        Collection doSomething(Map map) {
            System.out.println("child doSomething ....");
            return map.values();
        }

//        Collection doSomething(HashMap map){
//            System.out.println("child doSomething result is set....");
//            return new HashSet();
//        }

        Collection doSomething2(HashMap map) {
            System.out.println("child doSomething2 ....");
            return map.values();
        }
    }


    public static void main(String[] args) {
        /*****father doSomething ....
         father doSomething ....*******/
        HashMap map = new HashMap();

        Father f = new Father();
        Son c = new Son();

        f.doSomething(map);
        c.doSomething(map);

        f.doSomething2(map);
        c.doSomething2(map);
        /************/

    }
}
