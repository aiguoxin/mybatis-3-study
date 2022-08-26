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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import leetcode.bfs.TreeNode;

/**
 * 7/13/22 22:55
 * aiguoxin 
 * 说明:https://leetcode.cn/problems/subtree-of-another-tree/solution/ling-yi-ge-shu-de-zi-shu-by-leetcode-solution/
 */
public class SubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<String> rList = new LinkedList<>();
        List<String> sList = new LinkedList<>();
        dfs(root, rList);
        dfs(subRoot, sList);

        return Collections.indexOfSubList(rList, sList) != -1;
    }

    /**
     * 前序遍历是子串，前提是：补充左右子树空的情况
     * @param root
     * @param list
     */
    private void dfs(TreeNode root, List<String> list) {
        if (root != null) {
            list.add(root.val + "");
            dfs(root.left, list);
            dfs(root.right, list);
        } else {
            list.add("-");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n0 = new TreeNode(0);

        root.left = n4;
        root.right = n5;
        n4.left = n1;
        n4.right = n2;
        n2.left = n0;

        TreeNode r4 = new TreeNode(4);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        r4.left = r1;
        r4.right = r2;

        SubTree subTree = new SubTree();
        System.out.println(subTree.isSubtree(root, r4));
    }
}
