package leetcode.editor.cn;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 7635 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//import leetcode.ListNode;

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
class Solution0311 {
    public static ListNode addTwoNumbersForError(ListNode l1, ListNode l2) {
        //先拆成整数，相加后，再存入链表
        int i1 = l1.val;
        int i2 = l2.val;
        int i = 1;
        while (l1.next != null) {
            l1 = l1.next;
            i1 += l1.val * Math.pow(10, i);
            i++;
        }

        i = 1;
        while (l2.next != null) {
            l2 = l2.next;
            i2 += l2.val * Math.pow(10, i);
            i++;
        }

        /***超出int范围，导致挂了!!!!!!***/
        int sum = i1 + i2;
        System.out.println("sum=" + sum);

        ListNode header = null;
        ListNode tailer = null;

        while (sum / 10 >= 0) {
            ListNode node = new ListNode(sum % 10);
            if (header == null) {
                header = tailer = node;
            } else {
                tailer.next = node;
                tailer = node;
            }
            sum = sum / 10;
            if (sum == 0) {
                break;
            }
        }

        return header;
    }

    /*******写的代码有点恶心，看看别人咋写的**********/
    /**
     *  进位英文carry，进位，每次通过carray = value /10 计算出来，避免各种if..else
     *  carray !=0 的情况，放到while循环之外，简化
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = null;
        ListNode tailer = null;

        int extra = 0;
        int value;
        while (l1 != null || l2 != null) {
            if (l2 != null && l1 != null) {
                //直接相加,大于10，则%10，并进位+1
                value = l1.val + l2.val + extra;
                if (value > 9) {
                    value = value % 10;
                    extra = 1;
                } else {
                    extra = 0;
                }
                //新增node节点
                ListNode newNode = new ListNode(value);
                if (header == null) {
                    header = tailer = newNode;
                } else {
                    tailer.next = newNode;
                    tailer = newNode;
                }
                l1 = l1.next;
                l2 = l2.next;

                if (extra == 1 && l1 == null && l2 == null) {
                    ListNode extraNode = new ListNode(1);
                    tailer.next = extraNode;
                    tailer = extraNode;
                }
            } else if (l1 != null) {
                value = l1.val + extra;
                if (value > 9) {
                    value = value % 10;
                    extra = 1;
                    //新增node节点及节点1
                } else {
                    extra = 0;
                }
                //新增node节点
                ListNode newNode = new ListNode(value);
                if (header == null) {
                    header = tailer = newNode;
                } else {
                    tailer.next = newNode;
                    tailer = newNode;
                }
                l1 = l1.next;

                if (extra == 1 && l1 == null) {
                    ListNode extraNode = new ListNode(1);
                    tailer.next = extraNode;
                    tailer = extraNode;
                }
            } else if (l2 != null) {
                value = l2.val + extra;
                if (value > 9) {
                    value = value % 10;
                    extra = 1;
                } else {
                    extra = 0;
                }

                //新增node节点
                ListNode newNode = new ListNode(value);
                if (header == null) {
                    header = tailer = newNode;
                } else {
                    tailer.next = newNode;
                    tailer = newNode;
                }

                l2 = l2.next;
                if (extra == 1 && l2 == null) {
                    ListNode extraNode = new ListNode(1);
                    tailer.next = extraNode;
                    tailer = extraNode;
                }
            }

        }

        return header;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
//        ListNode node4 = new ListNode(3);
//        ListNode node3 = new ListNode(2);
//        l1.next = node4;
//        node4.next = node3;

        ListNode l2 = new ListNode(9);
//        ListNode node6 = new ListNode(2);
//        ListNode node44 = new ListNode(1);
//        l2.next = node6;
//        node6.next = node44;
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
