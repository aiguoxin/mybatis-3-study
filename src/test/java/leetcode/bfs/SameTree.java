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
package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2021/12/23 下午8:09
 * aiguoxin
 * 广度优先遍历，利用队列，queue处理
 * 说明: https://leetcode-cn.com/problems/same-tree/
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
//        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(2);
        q.right = new TreeNode(2);

        boolean same = isSameTree(p, q);
        System.out.println("same=" + same);
    }

    /**
     * 判断有点复杂
     * 怎么优化？ 主要是判断条件，采用异或运算符
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null & q != null) {
            return false;
        }
        if (p != null & q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        Queue<TreeNode> pList = new LinkedList<>();
        Queue<TreeNode> qList = new LinkedList<>();

        pList.add(p);
        qList.add(q);

        while (!pList.isEmpty() && !qList.isEmpty()) {
            TreeNode pFirst = pList.poll();
            TreeNode qFirst = qList.poll();

            if (pFirst.val != qFirst.val) {
                return false;
            }

            if (pFirst.left != null && qFirst.left != null) {
                pList.add(pFirst.left);
                qList.add(qFirst.left);
            }
            if (pFirst.right != null && qFirst.right != null) {
                pList.add(pFirst.right);
                qList.add(qFirst.right);
            }

            /**
             *  if (left1 == null ^ left2 == null) {
             *                 return false;
             *  }
             *  采用异或运算，不同则为1，则条件true，返回false，值得借鉴！！！
             *
             */
            if (pFirst.left == null && qFirst.left != null) {
                return false;
            }
            if (pFirst.left != null && qFirst.left == null) {
                return false;
            }

            if (pFirst.right == null && qFirst.right != null) {
                return false;
            }
            if (pFirst.right != null && qFirst.right == null) {
                return false;
            }
        }

        if (pList.size() != qList.size()) {
            return false;
        }

        return true;
    }
}
