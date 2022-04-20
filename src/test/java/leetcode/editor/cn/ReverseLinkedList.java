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
    //递归和直接使用当前和前一个指针，都比较抽象
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

    public static void main(String[] args) {
        //输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
        ListNode root = null;
//        ListNode n1 = new ListNode(2);
//        root.next = n1;
        ListNode res = reverseList(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
