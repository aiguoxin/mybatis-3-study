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

import java.util.Optional;

/**
 * 2021/4/23 下午3:40
 * aiguoxin
 * 说明:
 */
public class NullTest {
    public static void main(String[] args) {
        String name = null;
        name = Optional.ofNullable(name).orElse("");
        System.out.println("name="+name);
    }
}
