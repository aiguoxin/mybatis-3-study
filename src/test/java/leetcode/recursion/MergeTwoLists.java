/**
 *    Copyright 2009-2021 the original author or authors.
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

        //使用         cur.next = list1 == null ? list2 :list1; 优化
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

        // 还有递归解法：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/

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
