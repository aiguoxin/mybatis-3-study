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
package leetcode.recursion;

import java.util.Arrays;
import java.util.Stack;
import leetcode.ListNode;

/**
 * 7/16/22 19:44
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class PrintList {
    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int idx = 0;
        while (!stack.empty()) {
            res[idx++] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);

        root.next = n3;
        n3.next = n2;
        int[] res = reversePrint(root);
        System.out.println(Arrays.toString(res));
    }
}
