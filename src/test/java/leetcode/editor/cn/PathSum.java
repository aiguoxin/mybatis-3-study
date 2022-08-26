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
package leetcode.editor.cn;//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 824 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.bfs.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution032418 {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
                targetSum - root.val);
    }

    /*********多嵌套了一次！！！！************/
//    public static int computeSum(TreeNode node, int value) {
//        if (node == null) {
//            return value;
//        }
//
//        if (value < node.val) {
//            return value;
//        }
//
//        value = value - node.val;
//
//        if (node.left != null) {
//            return computeSum(node.left, value);
//        }
//
//        if (node.right != null) {
//            computeSum(node.right, value);
//        }
//        return value;
//    }

    public static void main(String[] args) {
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(13);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(1);


        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n3.left = n4;
        n3.right = n5;
        n5.right = n8;
        n3.left = n6;
        n3.right = n7;

        System.out.println(hasPathSum(root, 22));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
