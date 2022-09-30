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
package leetcode.editor.cn.greedy;

/***
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 * 偶数移动到偶数，或奇数移动到奇数，都是2n倍，移动之和是0
 * 如果是偶数与奇数之间移动，则是2n+1，移动是1
 * 分别找出奇数和偶数的个数，求最小
 *
 */
public class MinMove {
    public static int minCostToMoveChips(int[] position) {
        int odd =0, even=0;
        for (int value : position){
            if((value & 1) ==0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(odd,even);
    }

    public static void main(String[] args) {
        int[] pos = {1,1000000000};
        System.out.println(minCostToMoveChips(pos));
    }
}
