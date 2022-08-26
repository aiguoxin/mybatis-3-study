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
package leetcode.editor.cn;//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 
// 👍 865 👎 0


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
class Solution041511{

    //多使用了一个指针，可以优化。也可以使用递归思想
    public static ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = root.next;
        ListNode pre = root;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            cur = cur.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        //输入：head = [1,2,6,3], val = 6
//输出：[1,2,3,4,5]
        ListNode root = new ListNode(6);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(6);
        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        ListNode res = removeElements(null, 6);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
