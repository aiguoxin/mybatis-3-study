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
package leetcode.editor.cn;//请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
//
// 题目数据保证需要删除的节点 不是末尾节点 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,5,1,9], node = 5
//输出：[4,1,9]
//解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
// 
//
// 示例 2： 
//
// 
//输入：head = [4,5,1,9], node = 1
//输出：[4,5,9]
//解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [2, 1000] 
// -1000 <= Node.val <= 1000 
// 链表中每个节点的值都是 唯一 的 
// 需要删除的节点 node 是 链表中的节点 ，且 不是末尾节点 
// 
// Related Topics 链表 
// 👍 1136 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution042721{
    public static void deleteNode(ListNode node) {
        /**不是末尾节点很重要，可以伪装成子节点，再删子节点。 如果可以是尾结点呢？**/
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
