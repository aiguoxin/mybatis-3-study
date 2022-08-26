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
package leetcode.editor.cn;//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 105] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1362 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;
import leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution042616{
    /**
     * 其他解法：1、放入数组，前后比较 2、递归  3、找到后半节点，逆转
     *
     */
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode mid = null;

        while (p1 != null) {
            stack.push(p1.val);
            p1 = p1.next;
            if(p2.next.next == null){
                mid = p1;
                break;
            }
            p2 = p2.next.next;
            if(p2.next == null){
                mid = p1.next;
                break;
            }
        }

        while(mid != null){
            if(mid.val != stack.pop()){
                return false;
            }
            mid = mid.next;
        }


        return true;
    }

    public static void main(String[] args) {
        //输入：head = [1,2,2,1]
//输出：true
        ListNode root = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);

        root.next = n1;
        n1.next = n2;
        n2.next = n3;

        System.out.println(isPalindrome(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
