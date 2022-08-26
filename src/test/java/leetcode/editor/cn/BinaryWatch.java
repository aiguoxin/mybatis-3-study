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
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 6/11/22 18:11
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/binary-watch/
 */
public class BinaryWatch {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> resultList = new LinkedList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                /**注意Integer.bitCount使用!!!**/
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    resultList.add(h + ":" + (m > 9 ? "" : "0") + m);
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        readBinaryWatch(1)
                .stream()
                .forEach(data -> System.out.println(data));
    }
}
