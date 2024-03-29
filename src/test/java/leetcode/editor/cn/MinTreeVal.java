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

import java.util.LinkedList;
import java.util.List;
import leetcode.bfs.TreeNode;

/**
 * 7/4/22 08:07
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
 */
public class MinTreeVal {
    List<Integer> list = new LinkedList<>();

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        print(root);
        /**
         * 可以使用迭代优化，增加遍历pre记录前一个值，在递归的时候，即计算差值比较
         */
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i) - list.get(i - 1);
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private void print(TreeNode root) {
        if (root != null) {
            print(root.left);
            list.add(root.val);
            print(root.right);
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);

        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;

        MinTreeVal minTreeVal = new MinTreeVal();
        System.out.println(minTreeVal.getMinimumDifference(root));
    }
}
