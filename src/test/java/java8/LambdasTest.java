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

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/** 2020/10/9 下午5:07 aiguoxin 说明: */
public class LambdasTest {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {

        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {

        String value();
    };

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {}

//    @leetcode.Test
    public void testPrint() {
        Arrays.asList("a", "b", "d")
                .forEach(
                        e -> {
                            System.out.println(e);
                        });

        String[] stringArray = {
            "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"
        };
        Arrays.sort(stringArray, String::compareTo);
    }

    //    Scheduled注解就是repeated，方便多次执行不同时间任务
//    @leetcode.Test
    public void testRepeatedAno() {
        for (Filter annotation : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(annotation.value());
        }
        for (Filters annotation : Filterable.class.getAnnotationsByType(Filters.class)) {
            System.out.println(annotation.value());
        }
    }

    //    https://zhuanlan.zhihu.com/p/87983832，获取参数名更便捷，比如：MyBatis传递参数
    public static void main(String[] args) throws Exception {
        Method method = LambdasTest.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
    }
}
