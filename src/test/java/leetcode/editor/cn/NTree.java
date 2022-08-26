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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 7/10/22 16:39
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 */
public class NTree {
    List<Integer> resList = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return resList;
        }

        if (root != null) {
            resList.add(root.val);
        }

        if(root.children != null) {
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return resList;
    }

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return resList;
        }
        if(root.children != null) {
            for (Node node : root.children) {
                postorder(node);
            }
        }
        if (root != null) {
            resList.add(root.val);
        }

        return resList;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        List<Node> rChild = new ArrayList<>();
        rChild.add(n3);
        rChild.add(n2);
        rChild.add(n4);
        root.children = rChild;

        List<Node> n3Child = new ArrayList<>();
        n3Child.add(n5);
        n3Child.add(n6);
        n3.children = n3Child;

        NTree nTree = new NTree();
        System.out.println(nTree.postorder(root));
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
