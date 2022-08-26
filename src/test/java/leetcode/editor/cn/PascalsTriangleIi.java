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
package leetcode.editor.cn;//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
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
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 378 👎 0


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0329 {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(1);
        res.add(first);
        if (rowIndex == 0) {
            return first;
        }
//如何优化？ 1、滚动数组，可以不用 List<List<Integer>> res = new LinkedList<>();
        //2、倒推，比较难
        //3、数学公式推导，也比较麻烦，需要高数
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new LinkedList<>();
            List<Integer> last = res.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(j, 1);
                } else {
                    list.add(j, last.get(j - 1) + last.get(j));
                }
            }
            res.add(list);
        }

        return res.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> res = getRow(3);
        System.out.println(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
