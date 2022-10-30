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

import java.math.BigDecimal;
import org.junit.Test;

/**
 * 9/27/22 16:18
 * aiguoxin 
 * 说明:
 */
public class BigDecimalTest {
    @Test
    public void testMultiply(){
        System.out.println(BigDecimal.valueOf(60942).multiply(new BigDecimal("0.05")).setScale(2).intValue());
        System.out.println(BigDecimal.valueOf(44460).multiply(new BigDecimal("0.3")).setScale(2).intValue());
    }
}
