package leetcode.editor.cn;

import leetcode.bfs.TreeNode;

/**
 * 7/10/22 16:05
 * aiguoxin 
 * 说明: https://leetcode.cn/problems/binary-tree-tilt/
 */
public class Tilt {
    int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = dfs(root.left);
        int sumRight = dfs(root.right);
        /***
         * 递归过程需要用，全局sum
         */
        sum += Math.abs(sumLeft - sumRight);
        /**一定需要加上root.val**/
        return sumLeft + sumRight + root.val;
    }

    public static void main(String[] args) {

    }
}
