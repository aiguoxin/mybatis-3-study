package leetcode.linked;

import leetcode.ListNode;
import org.junit.Test;

/**
 * 11/20/22 13:04
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/add-two-numbers/
 */
public class Add {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;
        int add = 0;

        while (l1 != null || l2 != null) {
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = first + second + add;
            add = sum >= 10 ? 1 : 0;

            current.next = new ListNode(sum % 10);
            current = current.next;
            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;
        }
        /***这个别忘记了！***/
        if(add != 0){
            current.next = new ListNode(add);
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = null;

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
