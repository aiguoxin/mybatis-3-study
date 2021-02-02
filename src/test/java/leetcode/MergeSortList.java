package leetcode;

/** 2021/2/2 上午8:41 aiguoxin 说明: 合并两个有序列表 */
public class MergeSortList {
    public static void main(String[] args) {
        ListNode l1 = null;
        //        l1.next = new ListNode(2);
        //        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        //        l2.next = new ListNode(3);
        //        l2.next.next = new ListNode(4);

        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    // 使用两个指针同时进行  优化：递归实现
    // https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p3 = new ListNode();
        ListNode head = p3;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    p3.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    p3.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                p3 = p3.next;
            }

            if (l1 == null && l2 == null) {
                break;
            }

            if (l1 == null) {
                while (l2 != null) {
                    p3.next = new ListNode(l2.val);
                    l2 = l2.next;
                    p3 = p3.next;
                }
                break;
            }

            if (l2 == null) {
                while (l1 != null) {
                    p3.next = new ListNode(l1.val);
                    l1 = l1.next;
                    p3 = p3.next;
                }
                break;
            }
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
