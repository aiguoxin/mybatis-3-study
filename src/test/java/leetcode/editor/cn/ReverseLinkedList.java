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
package leetcode.editor.cn;//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 2455 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution041918 {

    //采用的尾插法
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;

        while(head.next != null){
            head = head.next;
        }

        while(first != head){
            ListNode cur = first;
            first = first.next;

            cur.next = head.next;
            head.next = cur;

        }

        return head;
    }


    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //保存上一节点
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

        public static void main(String[] args) {
        //输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
        ListNode root = null;
//        ListNode n1 = new ListNode(2);
//        root.next = n1;
        ListNode res = reverseList2(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
