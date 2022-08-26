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
 * 7/20/22 08:21
 * aiguoxin 
 * 说明:
 */
public class DivideNo {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            int div = i;
            boolean flag = true;
            while (div != 0) {
                int no = div % 10;
                div = div / 10;
                if (no == 0) {
                    flag = false;
                    break;
                } else {
                    if (i % no != 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(47, 85));
    }
}
