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
package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 2020/8/23 上午9:49
 * aiguoxin
 * 说明: 二叉树，一般用链表存储。如果是满二叉树或完全二叉树、堆，一般用数组存储
 */
public class BinaryTree {
    public static void main(String[] args) {
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        A.left = B;
        A.right = C;
//        preOrder(A);
//        middleOrder(A);
//        afterOrder(A);
        levelOrder(A);
    }

    static class Node{
        public Node(int value) {
            this.value = value;
        }

        private int value;
        private Node left;
        private Node right;
    }

    /**
     * 前序遍历
     */
    static void preOrder(Node root){
        if (Objects.isNull(root)) {
            return;
        }
        System.out.print(root.value+"\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    static void middleOrder(Node root){
        if (Objects.isNull(root)) {
            return;
        }
        middleOrder(root.left);
        System.out.print(root.value+"\t");
        middleOrder(root.right);
    }

    /**
     * 后序遍历
     * @param root
     */
    static void afterOrder(Node root){
        if (Objects.isNull(root)) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.value+"\t");
    }

    /**
     * 按层遍历
     * @param root
     */
    static List<List<Integer>> levels = new ArrayList<>();
    static void levelOrder(Node root){
        if(Objects.isNull(root)){
            return;
        }
        fromLevel(root,0);
        for(int i=0;i<levels.size();i++){
            List<Integer> values = levels.get(i);
            values.forEach(val->System.out.print(val+"\t"));
            System.out.println("");
        }
    }

    private static void fromLevel(Node node, int level) {
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.value);
        if(Objects.nonNull(node.left)){
            fromLevel(node.left,level+1);
        }
        if(Objects.nonNull(node.right)){
            fromLevel(node.right, level+1);
        }
    }
}
