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
package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2022/2/11 下午5:34
 * aiguoxin 
 * 说明: https://mohd-tanveer.medium.com/how-to-debug-java-streams-using-intellij-idea-56a2473b1009
 */
public class StreamDebug {
    public static void main(String[] args) {
//        List<String> collect = Stream.of("alen","go","home")
//                .filter(s->s.startsWith("a"))
//                .map(s->s.substring(3))
//                .distinct()
//                .sorted()
//                .collect(Collectors.toList());

        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).map(s->s+"-").collect(Collectors.toList());

        list.stream()
                .map(s -> s + "-")
                .collect(Collectors.toList());


        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }
}
