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
package java8.generics;

import java.util.function.Consumer;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 9/16/22 14:41
 * aiguoxin 
 * 说明:
 */
public class ConsumerTest {

    @Test
    public void testMethod() {
        Consumer<Integer> addTen = e -> System.out.println(e + 10);
        addTen.accept(10);

        Consumer<Integer> multiplyTen = e -> System.out.println(e * 10);
        addTen.andThen(multiplyTen).accept(10);
    }

    @Test
    public void test(){
        //1、接口实现
        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        //2、lambda
        print = e-> System.out.println(e);

        //3、方法引用
        print = System.out::print;


        //很多函数，入参是consumer，则可以方便使用
        Stream.of("1","2").forEach(print);
    }
}
