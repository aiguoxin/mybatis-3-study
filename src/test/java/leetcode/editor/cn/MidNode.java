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
package leetcode.editor.cn;

import leetcode.ListNode;

/**
 * 8/8/22 22:31
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/middle-of-the-linked-list/
 */
public class MidNode {

    public static ListNode middleNode(ListNode head) {
        ListNode p1 = head, p2 = head;
        if(head.next == null){
            return head;
        }
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p2 == null || p2.next == null){
                return p1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode n1= new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;

        ListNode res = middleNode(n1);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

}
