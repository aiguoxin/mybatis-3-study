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
package leetcode;

/**
 * 2022/3/8 下午4:46
 * aiguoxin 
 * 说明: 训练单链表的头插法与尾插法初始化
 */
public class InitLinkList {

    public static ListNode addFromHead(ListNode header, ListNode newNode) {
        if (header == null) {
            header = newNode;
        } else {
//            newNode.next = header.next;
//            header.next = newNode;
            newNode.next = header;
            header = newNode;

        }

        return header;
    }

    public static ListNode addFromTail(ListNode header, ListNode tailer, ListNode newNode) {
        if (header == null) {
            header = tailer = newNode;
        } else {
            tailer.next = newNode;
            tailer = newNode;
        }

        return header;
    }

    public static void main(String[] args) {
        ListNode header = null;
        ListNode tailer = null;

        for (int i = 0; i < 6; i++) {
            ListNode newNode = new ListNode(i);
//            header = addFromTail(header, tailer, newNode);
            if (header == null) {
                header = tailer = newNode;
            } else {
                tailer.next = newNode;
                tailer = newNode;
            }
        }

        while (header != null) {
            System.out.print(header.val);
            header = header.next;
            if (header != null) {
                System.out.print("->");
            }
        }

    }
}
