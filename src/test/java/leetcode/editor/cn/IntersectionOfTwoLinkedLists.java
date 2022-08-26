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
package leetcode.editor.cn;//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
//
// 图示两个链表在节点 c1 开始相交： 
//
// 
//
// 题目数据 保证 整个链式结构中不存在环。 
//
// 注意，函数返回结果后，链表必须 保持其原始结构 。 
//
// 自定义评测： 
//
// 评测系统 的输入如下（你设计的程序 不适用 此输入）： 
//
// 
// intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0 
// listA - 第一个链表 
// listB - 第二个链表 
// skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数 
// skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数 
// 
//
// 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视
//作正确答案 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, sk
//ipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 
//1
//输出：Intersected at '2'
//解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
//在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//这两个链表不相交，因此返回 null 。
// 
//
// 
//
// 提示： 
//
// 
// listA 中节点数目为 m 
// listB 中节点数目为 n 
// 1 <= m, n <= 3 * 104 
// 1 <= Node.val <= 105 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// 如果 listA 和 listB 没有交点，intersectVal 为 0 
// 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB] 
// 
//
// 
//
// 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？ 
// Related Topics 哈希表 链表 双指针 
// 👍 1646 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution040818{
    //开始理解错了：以为只有一个节点相交，其实是相交后的节点都一样

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针：每个链表一个指针，当遍历到null，则指向另外一个链表的头节点。 如果指向同一个节点，则返回。 如果都是null，则返回null
        //这个是什么原理呢？
        //其他思路：https://www.jianshu.com/p/9a953e4ad2cd
        //1、判断两个链表最后一个元素是否相同 2、第一个链表最后节点指向另外一个节点，再遍历另外一个节点，判断是否回到头结点
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != null || pB != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(2);
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(5);

        ListNode headB = new ListNode(4);
        ListNode b1 = new ListNode(2);

        headA.next = a1;
        a1.next = a2;

        headB.next = b1;
        b1.next = a1;

        System.out.println(getIntersectionNode(headA, headB).val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
