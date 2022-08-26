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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * 7/14/22 22:17
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/baseball-game/
 */
public class BaseBall {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("+");
        stringSet.add("C");
        stringSet.add("D");

        for (String str : ops) {
            if (stringSet.contains(str)) {
                if (Objects.equals("C", str)) {
                    stack.pop();
                } else if (Objects.equals("D", str)) {
                    int pre = stack.pop();
                    stack.push(pre);
                    stack.push(2 * pre);
                } else if (Objects.equals("+", str)) {
                    int pre = stack.pop();
                    int prepre = stack.pop();
                    stack.push(prepre);
                    stack.push(pre);
                    stack.push(pre + prepre);
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }

        //计算
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops));
    }
}
