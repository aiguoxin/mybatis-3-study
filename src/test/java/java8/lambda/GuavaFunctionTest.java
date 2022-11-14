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

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;

/**
 * 11/13/22 12:39
 * aiguoxin 
 * 说明:
 */
public class GuavaFunctionTest {

    @Test
    public void testList() {
        List<Integer> list = Lists.newArrayList(1, 2, 4);
        List<String> resultList = Lists.transform(list,e-> String.valueOf(e));
        System.out.println(resultList);
    }
}
