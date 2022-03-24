package leetcode.editor.cn;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 697 👎 0


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
class Solution032415 {
    public static int minDepth(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return 1;
        }

        if (root == null) {
            return 0;
        }
        /**没有考虑到根节点没有左子树或右子树极端情况，之前只用Math.min(minDepth(root.left), minDepth(root.right))+1 无法解决**/
        int min = Integer.MAX_VALUE;
        if(root.right != null){
            min = Math.min(min, minDepth(root.right));
        }

        if(root.left != null){
            min = Math.min(min, minDepth(root.left));
        }
        return min + 1;
    }

    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(2);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(6);

        root.right = n1;
        n1.right = n2;
        n2.right = n3;
        n3.right = n4;

        System.out.println(minDepth(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
