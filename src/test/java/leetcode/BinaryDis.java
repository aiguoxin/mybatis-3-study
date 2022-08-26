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
package leetcode;

/**
 * 6/20/22 08:42
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/hamming-distance/
 */
public class BinaryDis {
    public static int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = Integer.bitCount(res);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 1));
    }

//    输入：x = 1, y = 4
//    输出：2
}
