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
package java8.lambda;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 11/13/22 12:23
 * aiguoxin 
 * 说明:
 */
public class Test {

    @org.junit.Test
    public void testStream(){
        Optional<Integer> result = Stream.of("f","ba","hello")
                .map(s->s.length())
                .filter(l->l<=3)
                .max((o1,o2)->o1-o2);
        System.out.println(result.get());
    }
}
