package leetcode.recursion;

import leetcode.ListNode;

/**
 * 2022/2/7 下午4:17
 * aiguoxin
 * 说明: https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */
public class RmNodes {
    public static void main(String[] args) {
        ListNode head = null;
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(6);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(5);
//        ListNode node7 = new ListNode(6);
//
//        head.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        head = removeElements(head, 6);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 非递归方式实现
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode();
        ListNode cur = new ListNode();
        cur.next = head;
        pre.next = head;

        while (cur.next != null) {
            ListNode node = cur.next;
            if (node.val == val) {
                pre.next.next = node.next;
                //特殊处理头结点
                if(node == head){
                    head = pre.next.next;
                }
            } else {
                pre.next = node;
            }
            cur.next = node.next;
        }
        return head;
    }

    public static ListNode removeElementsByRecursion(ListNode head, int val){
        if(head == null){
            return head;
        }
        head.next = removeElementsByRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }
}
