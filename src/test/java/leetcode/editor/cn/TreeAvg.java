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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import leetcode.bfs.TreeNode;

/**
 * 7/31/22 15:43
 * aiguoxin 
 * 说明:
 */
public class TreeAvg {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> resList = new LinkedList<>();
        Deque<TreeNode> treeQ = new ArrayDeque<>();
        treeQ.add(root);
        while (!treeQ.isEmpty()) {
            int size = treeQ.size();
            int num = size;
            //注意越界
            long sum = 0;
            while (size != 0) {
                TreeNode node = treeQ.pop();
                size--;
                sum += node.val;
                if (node.left != null) {
                    treeQ.add(node.left);
                }
                if (node.right != null) {
                    treeQ.add(node.right);
                }
            }
            Double res = (double) sum / num;
            resList.add(res);
        }

        return resList;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(2147483647);
        TreeNode n9 = new TreeNode(2147483647);
        TreeNode n20 = new TreeNode(2147483647);

        n3.left = n9;
        n3.right = n20;
        System.out.println(averageOfLevels(n3));
    }

}
