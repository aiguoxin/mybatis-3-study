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

/**
 * 7/16/22 14:04
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/range-addition-ii
 */
public class RangeAdd {
    public static int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;
        for (int[] p : ops) {
            minM = Math.min(minM, p[0]);
            minN = Math.min(minN, p[1]);
        }
        return minM * minN;
    }

    public static void main(String[] args) {

    }
}
