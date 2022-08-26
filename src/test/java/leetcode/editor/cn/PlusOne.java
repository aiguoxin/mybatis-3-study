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
package leetcode.editor.cn;//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组 数学
// 👍 927 👎 0


/***
 * fixme 最初想法：转化成long，通过+1，再把long转化成数组。这样不行，因为数组长度<=100，超出范围了。
 *
 * 需要转换思维，判断有多少个连续9的元素!!!!
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0228 {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int mark = length - 1;

        for (int i = length - 1; i >= 0; i--) {
            mark = i;
            if (digits[i] == 9) {
                continue;
            }
            break;
        }
        System.out.println("最后一个数字不等于的下标：" + mark);

        //最后一位不是9
        if (mark == length - 1 && digits[mark] != 9) {
            digits[mark] = digits[mark] + 1;
            return digits;
        } else if (mark == 0 && digits[mark] == 9) {  //全部为9
            int[] res = new int[length + 1];
            res[0] = 1;
            return res;
        } else {        //有不为9的
            digits[mark] = digits[mark] + 1;
            for (int j = mark + 1; j <= length - 1; j++) {
                digits[j] = 0;
            }
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {3,1,9};

        int[] res = plusOne(digits);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
