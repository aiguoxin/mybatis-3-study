package leetcode.recursion;

/**
 * 2021/12/6 下午7:04
 * aiguoxin
 * 说明:https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = null;
//        ListNode list12 = new ListNode(2);
//        ListNode list13 = new ListNode(4);
//        list1.next = null;
//        list12.next = list13;
//        list13.next = null;

        ListNode list2 = new ListNode(1);
        ListNode list22 = new ListNode(3);
        ListNode list23 = new ListNode(4);
        list2.next = list22;
        list22.next = list23;
        list23.next = null;
        ;
        ListNode head = mergeTwoLists(list1, list2);
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode cur = new ListNode();
        head = cur;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }

        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }

        return head.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
