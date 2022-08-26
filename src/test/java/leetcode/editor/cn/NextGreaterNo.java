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

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 6/24/22 08:05
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/next-greater-element-i/
 */
public class NextGreaterNo {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums1.length; i++) {
            int idx = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    idx = j;
                    if (idx > nums1.length) {
                        break;
                    }
                    continue;
                }
                if (nums2[j] > nums1[i] && j > idx && idx != -1) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }

        return res;
    }

    /***
     * 倒序遍历，并把主数组存入hash表中
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElementG(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] res = nextGreaterElementG(nums1, nums2);
        Arrays.stream(res).forEach(data -> System.out.println(data));
    }
}
