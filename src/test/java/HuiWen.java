/**
 *    Copyright 2009-2020 the original author or authors.
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
/**
 * 2020/6/22 上午11:55
 * aiguoxin
 * 说明: 单链表是否回文：a->b->c->b-a
 */
public class HuiWen {

    public static void main(String[] args) {
        Node<Character> five = new Node('a',null);
        Node<Character> four = new Node('b',five);
        Node<Character> third = new Node('c',four);
        Node<Character> second = new Node('b',third);
        Node<Character> first = new Node('a',second);
        Node<Character> head = new Node(null,first);
        System.out.println("起始链表：");
        while(head.next != null){
            System.out.print("->"+head.next.getData());
            head.next = head.next.next;

        }

        head.next = first;
        HuiWen huiWen = new HuiWen();
        huiWen.checkByPoint(head);
    }

    /**
     * 使用双指针，快慢，慢走一步，快走两步，快最后没有，则慢指向中间节点
     * @return
     */
    public boolean checkByPoint(Node<Character> head){
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }

        Node<Character> fast = new Node(null, head.next);
        Node<Character> slow = new Node(null, head.next);

        Node<Character> middle = findMiddleNode(fast,slow,head);
        Node<Character> rightHead = reverseRightList(middle);
        System.out.print("右链表逆转如下：");
        while(rightHead.next != null){
            System.out.print("->"+rightHead.getData());
            rightHead = rightHead.next;
        }

        System.out.println("------------------------");
        System.out.println("middle="+middle.getData());
        return false;
    }

    /**
     * 单链接表反转：3个指针，前后、当前
     * @param middle
     * @return
     */
    private Node reverseRightList(Node<Character> middle) {
        if(middle == null || middle.next == null){
            return middle;
        }
        Node<Character> head = new Node(null, middle);
        Node<Character> pre = null;
        Node<Character> next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private Node findMiddleNode(Node<Character> fast, Node<Character> slow, Node<Character> head) {
        while(fast.next != null && fast.next.next != null &&  fast.next.next.next != null){
            slow.next = slow.next.next;
            fast.next = fast.next.next.next;
        }
        return slow.next;
    }

    /**
     * 借助栈
     * @return
     */
    public boolean checkByStack(){

        return false;
    }

    static class Node<T>{
        T data;

        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }



    }
}
