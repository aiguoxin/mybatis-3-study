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

/**
 * 2022/1/30 上午10:57
 * aiguoxin
 * 说明:
 */
public class A<T> {
    public static <T> void test(T t){
        System.out.println(t.toString());
    }

    /**static方法无法感知T，报错**/
//    public static void test1(T t){
//        System.out.println(t.toString());
//    }
}
