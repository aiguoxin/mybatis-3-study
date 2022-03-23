package leetcode.editor.cn;//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 935 👎 0


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
class Solution032321 {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }


        while (root != null) {
            if (Math.abs(high(root.left) - high(root.right)) > 1) {
                return false;
            }
            /********没想出最后这个递归*********/
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return true;
    }

    public static int high(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(high(root.left), high(root.right)) + 1;
    }

    public static void main(String[] args) {
//输入：root = [1,2,2,3,3,null,null,4,4]
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);


        root.left = n1;
        root.right = n2;

        n1.left = n3;
        n1.right = n4;

        n3.left = n5;
        n3.right = n6;
        System.out.println(isBalanced(root));

    }
}
//leetcode submit region end(Prohibit modification and deletion)
