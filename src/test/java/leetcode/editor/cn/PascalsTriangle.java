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
package leetcode.editor.cn;//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 720 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution032511 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(1);
        res.add(first);

        if (numRows == 1) {
            return res;
        }

        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new LinkedList<>();
            List<Integer> last = res.get(i - 2);

            for (int j = 0; j < i; j++) {
                int left = 0, right = 0;
                if (j - 1 >= 0) {
                    left = last.get(j - 1);
                }
                if (j+1 < i) {
                    right = last.get(j);
                }
                int value = left + right;
                list.add(value);
            }
            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(6);
        result.stream().forEach(e -> System.out.println(e));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
