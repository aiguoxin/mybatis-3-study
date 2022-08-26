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

import java.util.BitSet;

/**
 * 2022/2/7 下午6:30
 * aiguoxin
 * 说明:
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bs1 = new BitSet();
        bs1.set(0);
        bs1.set(2);
        bs1.set(4);
        System.out.println("bs1 : " + bs1);

        BitSet bs2 = new BitSet();
        bs2.set(1);
        bs2.set(2);
        bs2.set(3);
        System.out.println("bs2 : " + bs2);

        bs2.xor(bs1);
        System.out.println("xor: " + bs2);
    }
}
