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
