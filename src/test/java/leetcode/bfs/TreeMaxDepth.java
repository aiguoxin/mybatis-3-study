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

/**
 * 2022/1/5 下午8:00
 * aiguoxin
 * 说明: 找出二叉树最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 **/

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */

public class TreeMaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        root.left = t9;
        root.right = t20;

        t20.left = t15;
        t20.right = t7;
//        System.out.println(maxDepth(root));
        System.out.println(maxDepthByDFS(root));

    }

    public static int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            //这层循环是处理每层的元素都需处理完，处理完一层的元素，深度+1。难点，没想到💦
            int queueSize = queue.size();
            while (queueSize > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                queueSize--;
            }

            maxDepth++;
        }
        return maxDepth;
    }

    public static int maxDepthByDFS(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepthByDFS(root.left), maxDepthByDFS(root.right)) + 1;
    }
}


