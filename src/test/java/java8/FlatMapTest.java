/**
 *    Copyright 2009-2021 the original author or authors.
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
package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/** 2021/4/16 下午6:10 aiguoxin 说明: 比较Map与FlatMap区别 */
public class FlatMapTest {

    public static void main(String[] args) {
        String s1 = "This is a";
        String s2 = "flatMap example";

        List<String> result =
                Stream.of(s1, s2)
                        .flatMap(s -> Stream.of(s.split(" ")))
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
        assertEquals(Arrays.asList("THIS", "IS", "A", "FLATMAP", "EXAMPLE"), result);
        System.out.println("list=" + result);
    }
}
