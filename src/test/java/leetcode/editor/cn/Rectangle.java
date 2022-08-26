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

import java.util.Arrays;

/**
 * 6/26/22 20:36
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/construct-the-rectangle/
 */
public class Rectangle {
    //优化：从平方根后开始，最小数肯定小于等于平方根的
    public static int[] constructRectangle(int area) {
        int[] res = {area, 1};
        int value = area - 1;
        for (int i = 2; i < area; i++) {
            if (area % i == 0) {
                int compute = area / i;
                if (compute - i < value && value > 0) {
                    res[0] = i;
                    res[1] = compute;
                    value = compute - i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = constructRectangle(122122);
        Arrays.stream(res).forEach(e -> System.out.println(e));
    }
}
